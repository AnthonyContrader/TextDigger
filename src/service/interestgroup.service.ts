import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { InterestGroupDTO } from 'src/dto/interestgroupdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class InterestGroupService extends AbstractService<InterestGroupDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type= "interestgroup";
    }
}