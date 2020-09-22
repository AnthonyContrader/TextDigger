import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { SubscribeDTO } from '../dto/subscribedto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SubscribeService extends AbstractService<SubscribeDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type= 'subscribes';
    this.micro= '';
   }
}
