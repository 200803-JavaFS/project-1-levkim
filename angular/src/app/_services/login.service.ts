import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { User } from "../_models/user";
import { Observable } from 'rxjs';
import { Http2ServerResponse } from 'http2';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = "http://localhost:8080/project1";
  }

  public login(user: User) {
    return this.http.post<User>(`${this.baseUrl}/login`, user, {observe: 'response', withCredentials: true});
  }

  public logout() {
    return this.http.options(`${this.baseUrl}/logout`, {withCredentials: true});
  }

}
