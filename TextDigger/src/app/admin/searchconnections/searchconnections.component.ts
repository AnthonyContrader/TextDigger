import { Component, OnInit } from '@angular/core';
import { SearchConnectionDTO } from 'src/dto/searchconnectiondto';
import { SearchconnectionService } from 'src/service/searchconnection.service';
import { TagDTO } from 'src/dto/tagdto';
import { DocumentDTO } from 'src/dto/documentdto';
import { TagService } from 'src/service/tag.service';
import { DocumentService } from 'src/service/document.service';

@Component({
  selector: 'app-searchconnections',
  templateUrl: './searchconnections.component.html',
  styleUrls: ['./searchconnections.component.css']
})
export class SearchconnectionsComponent implements OnInit {

  searchconnections: SearchConnectionDTO[];
  searchconnectiontoinsert: SearchConnectionDTO = new SearchConnectionDTO();
  tags: TagDTO[];
  documents: DocumentDTO[];

  constructor(private service: SearchconnectionService, private service_tag:TagService, private service_document: DocumentService) { }

  ngOnInit() {
    this.getSearchConnections();
    this.getTags();
    this.getDocuments();
  }

  getSearchConnections(){
    this.service.getAll().subscribe(searchconnections => this.searchconnections = searchconnections);
  }

  getTags(){
    this.service_tag.getAll().subscribe(tags => this.tags = tags);
  }

  getDocuments(){
    this.service_document.getAll().subscribe(documents => this.documents = documents);
  }

  delete(searchconnection: SearchConnectionDTO) {
    this.service.delete(searchconnection.id).subscribe(() => this.getSearchConnections());
  }

  update(searchconnection: SearchConnectionDTO) {
    this.service.update(searchconnection).subscribe(() => this.getSearchConnections());
  }

  insert(searchconnection: SearchConnectionDTO) {
    this.service.insert(searchconnection).subscribe(() => this.getSearchConnections());
  }

  clear(){
    this.searchconnectiontoinsert = new SearchConnectionDTO();
  }

}