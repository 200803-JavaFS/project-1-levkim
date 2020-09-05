import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { User } from "../user";
import { Reimbursement } from "../reimbursement";

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  constructor(private http: HttpClient) { }

  configUrl = "assets/config.json";
  user = User;
  reimb = Reimbursement;
  reimbs = [];

  getConfig() {
    return this.http.get(this.configUrl);
  }

  login() {
  }
  
  addReimb() {
    this.reimbs.push(this.reimb);
  };

  getReimb() {
    return this.reimbs;
  };

  updateReimb() {

  }
}
