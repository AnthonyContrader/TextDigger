import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { InterestDTO } from 'src/dto/interestdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class InterestService extends AbstractService<InterestDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type= "interest";
    }
}