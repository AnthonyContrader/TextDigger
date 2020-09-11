import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Service } from './service';
import { HttpClient } from '@angular/common/http';
import { UserDTO } from '../dto/userdto';


@Injectable({
  providedIn: 'root'
})
export abstract class AbstractService<DTO> implements Service<DTO> {

  type: string;
  port: string = '8080';
  user: UserDTO;
  micro: string;

  constructor(protected http: HttpClient) {
  }
  auth() {
      this.user = JSON.parse(localStorage.getItem('currentUser'));
      if(this.user) {
          return 'Bearer ' + this.user.authorities;
      } else {
          return '';
      }
    }


  getAll(): Observable<DTO[]> {
      return this.http.get<DTO[]>('http://localhost:' + this.port + '/' + this.micro + '/api/' + this.type,  {
          headers: {
            Authorization: this.auth()
          }
      });
  }

  read(id: number): Observable<DTO> {
      return this.http.get<DTO>('http://localhost:' + this.port + '/' + this.micro + '/api/' + this.type + '/' + id, {
          headers: {
            Authorization: this.auth()
          }
      });
  }

  delete(id: number): Observable<any> {
      return this.http.delete('http://localhost:' + this.port + '/' + this.micro + '/api/' + this.type + '/' + id, {
          headers: {
            Authorization: this.auth()
          }
      });
  }

  insert(dto: DTO): Observable<any> {
      return this.http.post('http://localhost:' + this.port + '/' + this.micro + '/api/' + this.type, dto, {
          headers: {
            Authorization: this.auth()
          }
      });
  }

  update(dto: DTO): Observable<DTO> {
      return this.http.put<DTO>('http://localhost:' + this.port + '/' + this.micro + '/api/' + this.type, dto, {
          headers: {
            Authorization: this.auth()
          }
      });

  }
}
