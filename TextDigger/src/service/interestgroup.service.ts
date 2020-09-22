import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { InterestGroupDTO } from '../dto/interestgroupdto';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})
export class InterestgroupService extends AbstractService<InterestGroupDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'interestgroups';
    this.micro = '';
   }
}
