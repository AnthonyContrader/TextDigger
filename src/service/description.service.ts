import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { DescriptionDTO } from 'src/dto/descriptiondto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class DescriptionService extends AbstractService<DescriptionDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = "description";
    }
}