import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LibraryDTO } from '../dto/librarydto';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})
export class LibraryService extends AbstractService<LibraryDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type= 'libraries';
    this.micro = '';
   }
}
