import { Component, OnInit } from '@angular/core';
import { FolderDTO } from 'src/dto/folderdto';
import { FolderService } from 'src/service/folder.service';
import { LibraryDTO } from 'src/dto/librarydto';
import { LibraryService } from 'src/service/library.service';

@Component({
  selector: 'app-folders',
  templateUrl: './folders.component.html',
  styleUrls: ['./folders.component.css']
})
export class FoldersComponent implements OnInit {

  folders: FolderDTO[];
  foldertoinsert: FolderDTO = new FolderDTO();
  libraries: LibraryDTO[];

  constructor(private service: FolderService, private service_library: LibraryService) { }

  ngOnInit() {
    this.getFolders();
    this.getLibraries();
  }

  getFolders(){
    this.service.getAll().subscribe(folders => this.folders = folders);
  }

  getLibraries(){
    this.service_library.getAll().subscribe(libraries => this.libraries = libraries);
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