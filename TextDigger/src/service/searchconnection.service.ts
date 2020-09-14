import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SearchConnectionDTO } from '../dto/searchconnectiondto';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})
export class SearchconnectionService extends AbstractService<SearchConnectionDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type= "searchconnections";
    this.micro= "textdigger";
   }
}
