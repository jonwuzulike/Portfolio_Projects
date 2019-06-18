import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reimbursement } from '../models/reimbursement';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {


  allUrl = "http://localhost:8080/ERS_SpringMVC/reimbursements";
  byIdUrl = "http://localhost:8080/ERS_SpringMVC/reimbursement/user";

  constructor(private http: HttpClient) { }

  //Gets all reimbursments (manager) 
  getAll(): Observable<Reimbursement[]> {
    return this.http.get<Reimbursement[]>(this.allUrl);
  }

  //Gets all reimbursement for user.
  getById(id) {
    return this.http.get<Reimbursement>(this.byIdUrl, {
      params: {
        id: id
      }
    }
    );
  }

  //Submit a reimbursement request.

  //Approve or deny a reimbursement request.

}
