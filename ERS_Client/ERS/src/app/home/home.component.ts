import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from '../services/user-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  email: String;
  password: String;
  user: User;
  obj: any;
  title: String = "Secret Intelligence Service"
  constructor(private router: Router, private service: UserServiceService) { }

  ngOnInit() {
  }

  showLogin() {
    document.getElementById("login").style.visibility = "visible";
  }

  submitInput() {
    console.log(this.email);
    console.log(this.password);

    let obj = this.service.login(this.email, this.password).subscribe(
      (data) => {
        this.user = data;
        console.log(this.user);
        this.service.setCurrentUser(this.user);
        if (this.user !== null || this.user !== undefined) {
         if (this.user.userTypeId === 1) {
          this.router.navigate(["/employee"]);
         } else {
          this.router.navigate(["/manager"]);
         }
        }
      }

    )

  
  
  }








  }




