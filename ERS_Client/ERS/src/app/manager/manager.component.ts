import { Component, OnInit } from '@angular/core';
import { ReimbursementService } from '../services/reimbursement.service';
import { UserServiceService } from '../services/user-service.service';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  constructor(private service: UserServiceService, private rService: ReimbursementService) { }

  user: User;
  ngOnInit() {

    this.user = this.service.getCurrentUser();
    this.rService.getAll().subscribe(
      (data) => {
        console.log(data);
      }
    )
  }

}
