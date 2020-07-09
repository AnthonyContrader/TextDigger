import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { LibraryDTO } from 'src/dto/librarydto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class LibraryService extends AbstractService<LibraryDTO>{

    constructor(http: HttpClient){
        super(http);
        this.type= "library";
    }
}