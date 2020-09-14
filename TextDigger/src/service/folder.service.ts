import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FolderDTO } from '../dto/folderdto';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})
export class FolderService extends AbstractService<FolderDTO> {

  constructor(http: HttpClient) { 
    super(http);
    this.type="folders";
    this.micro="textdigger";
  }
}
