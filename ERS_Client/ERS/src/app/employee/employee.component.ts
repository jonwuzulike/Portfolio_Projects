import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../services/user-service.service';
import { Router } from '@angular/router';
import { ReimbursementService } from '../services/reimbursement.service';
import { Reimbursement } from '../models/reimbursement';


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  obj: any;
  user: User;
  reim: Reimbursement;
  reims: Reimbursement[] = [];
  constructor(private service: UserServiceService, private router: Router, private rService: ReimbursementService) {

  }

  ngOnInit() {
    this.user = this.service.getCurrentUser();
    if (this.user == undefined || this.user === null) {
      this.router.navigate(["/home"]);
    }

    //Getting the reimbursements for the usr.
    this.rService.getById(this.user.id).subscribe(
      (data) => {
      console.log(data);
      this.reim = data;
      console.log(this.reim);
      console.log(this.reim[0].name)
      }
    )
  }


}
