import { Component, OnInit } from '@angular/core';
import { FolderDTO } from 'src/dto/folderdto';
import { FolderService } from 'src/service/folder.service';
import { LibraryDTO } from 'src/dto/librarydto';
import { DescriptionDTO } from 'src/dto/descriptiondto';
import { LibraryService } from 'src/service/library.service';
import { DescriptionService } from 'src/service/description.service';

@Component({
  selector: 'app-folders',
  templateUrl: './folders.component.html',
  styleUrls: ['./folders.component.css']
})
export class FoldersComponent implements OnInit {

  folders: FolderDTO[];
  foldertoinsert: FolderDTO = new FolderDTO();
  libraries: LibraryDTO[];
  descriptions: DescriptionDTO[];

  constructor(private service: FolderService, private service_library: LibraryService, private service_description: DescriptionService) { }

  ngOnInit() {
    this.getFolders();
    this.getLibraries();
    this.getDescriptions();
  }

  getFolders(){
    this.service.getAll().subscribe(folders => this.folders = this.folders);
  }

  getLibraries(){
    this.service_library.getAll().subscribe(libraries => this.libraries = this.libraries);
  }

  getDescriptions(){
    this.service_description.getAll().subscribe(descriptions => this.descriptions = this.descriptions);
  }

  delete(folder: FolderDTO) {
    this.service.delete(folder.id).subscribe(() => this.getFolders());
  }

  update(folder: FolderDTO) {
    this.service.update(folder).subscribe(() => this.getFolders());
  }

  insert(folder: FolderDTO) {
    this.service.insert(folder).subscribe(() => this.getFolders());
  }

  clear(){
    this.foldertoinsert = new FolderDTO();
  }

}
