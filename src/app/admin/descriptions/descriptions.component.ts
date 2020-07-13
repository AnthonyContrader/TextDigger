import { Component, OnInit } from '@angular/core';
import { DescriptionDTO } from 'src/dto/descriptiondto';
import { DescriptionService } from 'src/service/description.service';
import { FolderDTO } from 'src/dto/folderdto';
import { LibraryDTO } from 'src/dto/librarydto';
import { InterestDTO } from 'src/dto/interestdto';
import { FolderService } from 'src/service/folder.service';
import { LibraryService } from 'src/service/library.service';
import { InterestService } from 'src/service/interest.service';
import { DocumentDTO } from 'src/dto/documentdto';
import { DocumentService } from 'src/service/document.service';

@Component({
  selector: 'app-descriptions',
  templateUrl: './descriptions.component.html',
  styleUrls: ['./descriptions.component.css']
})
export class DescriptionsComponent implements OnInit {

  descriptions: DescriptionDTO[];
  descriptiontoinsert: DescriptionDTO = new DescriptionDTO();
  folders: FolderDTO[];
  libraries: LibraryDTO[];
  interests: InterestDTO[];
  documents: DocumentDTO[];

  constructor(private service: DescriptionService, private service_folder: FolderService, private service_library: LibraryService, private service_interest: InterestService, 
    private service_document: DocumentService) { }

  ngOnInit() {
    this.getDescriptions();
    this.getFolders();
    this.getLibraries();
    this.getInterests();
    this.getDocuments();
  }

  getDescriptions() {
    this.service.getAll().subscribe(descriptions => this.descriptions = descriptions);
  }

  getFolders(){
    this.service_folder.getAll().subscribe(folders => this.folders = folders);
  }

  getLibraries(){
    this.service_library.getAll().subscribe(libraries => this.libraries = libraries);
  }

  getInterests(){
    this.service_interest.getAll().subscribe(interests => this.interests = interests);
  }

  getDocuments(){
    this.service_document.getAll().subscribe(documents => this.documents = documents);
  }

  delete(description: DescriptionDTO) {
    this.service.delete(description.id).subscribe(() => this.getDescriptions());
  }

  update(description: DescriptionDTO) {
    this.service.update(description).subscribe(() => this.getDescriptions());
  }

  insert(description: DescriptionDTO) {
    this.service.insert(description).subscribe(() => this.getDescriptions());
  }

  clear(){
    this.descriptiontoinsert = new DescriptionDTO();
  }

}
