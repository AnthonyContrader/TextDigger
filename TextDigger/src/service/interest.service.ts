import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { InterestDTO } from '../dto/interestdto';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})
export class InterestService extends AbstractService<InterestDTO> {

  constructor(http: HttpClient) { 
    super(http);
    this.type= 'interests';
    this.micro= '';
  }
}
