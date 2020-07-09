import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { SubscribeDTO } from 'src/dto/subscribedto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class SubscribeService extends AbstractService<SubscribeDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type= "subscribe;"
    }
}