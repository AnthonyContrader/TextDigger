import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { DocumentDTO } from 'src/dto/documentdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class DocumentService extends AbstractService<DocumentDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type = "document";
    }
}