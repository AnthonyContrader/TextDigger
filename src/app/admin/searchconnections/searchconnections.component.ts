import { Component, OnInit } from '@angular/core';
import { SearchConnectionDTO } from 'src/dto/searchconnectiodto';
import { SearchConnectionService } from 'src/service/searchconnection.service';

@Component({
  selector: 'app-searchconnections',
  templateUrl: './searchconnections.component.html',
  styleUrls: ['./searchconnections.component.css']
})
export class SearchconnectionsComponent implements OnInit {

  searchconnections: SearchConnectionDTO[];
  searchconnectiontoinsert: SearchConnectionDTO = new SearchConnectionDTO();

  constructor(private service: SearchConnectionService) { }

  ngOnInit() {
    this.getSearchConnections()
  }

  getSearchConnections(){
    this.service.getAll().subscribe(searchconnections => this.searchconnections = this.searchconnections);
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
