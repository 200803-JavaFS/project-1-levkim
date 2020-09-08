import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reimbursement } from '../_models/reimbursement';

@Injectable({
  providedIn: 'root'
})
export class ReimbService {

  baseUrl = "http://localhost:8080/project1";

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(`${this.baseUrl}/reimbursement`);
  }

  getOne(id: number) {
    return this.http.get(`${this.baseUrl}/reimbursement/${id}`);
  }

  add(reimbursement: JSON) {
    return this.http.post(`${this.baseUrl}`, reimbursement, {responseType: 'json', withCredentials: true});
  }

  update(reimbursement: JSON) {
    return this.http.post(`${this.baseUrl}`, reimbursement, { responseType: 'json', withCredentials: true });
  }

}
