import { Component, OnInit } from '@angular/core';
import { DocumentDTO } from 'src/dto/documentdto';
import { DescriptionDTO } from 'src/dto/descriptiondto';
import { DocumentService } from 'src/service/document.service';
import { UserDTO } from 'src/dto/userdto';
import { FolderDTO } from 'src/dto/folderdto';
import { UserService } from 'src/service/user.service';
import { FolderService } from 'src/service/folder.service';
import { DescriptionService } from 'src/service/description.service';

@Component({
  selector: 'app-documents',
  templateUrl: './documents.component.html',
  styleUrls: ['./documents.component.css']
})
export class DocumentsComponent implements OnInit {

  documents: DocumentDTO[];
  documenttoinsert: DocumentDTO = new DocumentDTO();
  users: UserDTO[];
  folders: FolderDTO[];
  descriptions: DescriptionDTO[];

  constructor(private service: DocumentService, private service_user: UserService, private service_folder: FolderService, private service_description: DescriptionService) { }

  ngOnInit() {
    this.getDocuments();
    this.getUsers();
    this.getFolders();
    this.getDescriptions();
  }

  getDocuments(){
    this.service.getAll().subscribe(documents => this.documents = documents);
  }

  getUsers(){
    this.service_user.getAll().subscribe(users => this.users = users);
  }

  getFolders(){
    this.service_folder.getAll().subscribe(folders => this.folders = folders);
  }

  getDescriptions(){
    this.service_description.getAll().subscribe(descriptions => this.descriptions = descriptions);
  }

  delete(document: DocumentDTO) {
    this.service.delete(document.id).subscribe(() => this.getDocuments());
  }

  update(document: DocumentDTO) {
    this.service.update(document).subscribe(() => this.getDocuments());
  }

  insert(document: DocumentDTO) {
    this.service.insert(document).subscribe(() => this.getDocuments());
  }

  clear(){
    this.documenttoinsert = new DocumentDTO();
  }

}
