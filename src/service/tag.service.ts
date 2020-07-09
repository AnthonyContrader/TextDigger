import { AbstractService } from './abstractservice';
import { TagDTO } from 'src/dto/tagdto';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class TagService extends AbstractService<TagDTO> {

    constructor(http: HttpClient) {
        super(http);
        this.type = "tag";
    }

}