import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginDTO } from '../dto/logindto';
import { UserDTO } from '../dto/userdto';
import { AbstractService } from './abstractservice';
@Injectable({
  providedIn: 'root'
})
export class UserService extends AbstractService<UserDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'users';
  }

  auth() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    console.log("stampa user: " + localStorage.getItem('currentUser'))
    if (this.user) {
      return 'Bearer ' + this.user.authorities;
    } else {
      return '';
    }
  } 

  login(loginDTO: LoginDTO): Observable<UserDTO> {
    return this.http.post<any>('http://localhost:8080/api/authenticate', loginDTO)
  }

  getUserLogged(username: string) {
    return this.http.get('http://localhost:8080/api/users/' + username,
      {
        headers: { Authorization: this.auth() }
      });
  }

  readUser(login: string): Observable<UserDTO> {
    return this.http.get<UserDTO>('http://localhost:' + this.port + '/api/' + this.type + '/' + login, {
        headers: {
          Authorization: this.auth()
        }
    });
  }

  getAll(): Observable<UserDTO[]> {
    return this.http.get<UserDTO[]>('http://localhost:' + this.port + '/api/' + this.type,  {
        headers: {
          Authorization: this.auth()
        }
    });
  } 

  deleteUser(login: string): Observable<any> {
    return this.http.delete('http://localhost:' + this.port + '/api/' + this.type + '/' + login, {
        headers: {
          Authorization: this.auth()
        }
    });
  }

  insert(dto: UserDTO): Observable<any> {
    return this.http.post('http://localhost:' + this.port + '/api/' + this.type, dto, {
        headers: {
          Authorization: this.auth()
        }
    });
  }

  update(dto: UserDTO): Observable<UserDTO> {
    return this.http.put<UserDTO>('http://localhost:' + this.port + '/api/' + this.type, dto, {
        headers: {
          Authorization: this.auth()
        }
    });
  }

}
