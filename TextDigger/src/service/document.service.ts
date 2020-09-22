import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { DocumentDTO} from '../dto/documentdto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DocumentService extends AbstractService<DocumentDTO> {

  constructor(http: HttpClient) { 
    super(http);
    this.type = 'documents';
    this.micro = '';
  }
}
