import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  user: User;
  constructor(private service: UserServiceService, private router: Router) {

  }

  ngOnInit() {
 this.user=  this.service.getCurrentUser();
  }


}
