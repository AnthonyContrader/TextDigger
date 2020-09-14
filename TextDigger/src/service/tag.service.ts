import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TagDTO } from '../dto/tagdto';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})
export class TagService extends AbstractService<TagDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type= "tags";
    this.micro= "textdigger";
   }
}
