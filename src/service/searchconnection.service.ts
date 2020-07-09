import { Injectable } from "@angular/core";
import { AbstractService } from './abstractservice';
import { SearchConnectionDTO } from 'src/dto/searchconnectiodto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class SearchConnectionService extends AbstractService<SearchConnectionDTO>{
    
    constructor(http: HttpClient){
        super(http);
        this.type= "searchconnection";
    }
}