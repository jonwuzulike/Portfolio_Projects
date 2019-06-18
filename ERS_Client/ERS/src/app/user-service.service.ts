import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  user: User;

  //Url for login
  loginUrl = "http://localhost:8080/ERS_SpringMVC/login"

  //Url to get all users.
  allUsersUrl = "http://localhost:8080/ERS_SpringMVC/users"

  constructor(private http: HttpClient) { }

  //Login user.
  login(email, password) {
   return this.http.get<User>(this.loginUrl,
      {
        params: {
          email: email,
          password: password
        }
      }

    );
  }
  //Sets the current logged in user.
  setCurrentUser(currentUser: User) {
    this.user = currentUser;
    if (this.user !== null) {
      console.log("Current user is set.");
    } else {
      console.log("Not able to set the curretn user.");
    }
  }
  //Gets the current logged in user.
  getCurrentUser(): User {
    console.log("Returning the current user " + this.user);
    return this.user;
  }

  //Gets all the users.
  getAllUsers() {
    this.http.get<User>(this.allUsersUrl, {
    }).subscribe(
      (data) => {
        console.log(data)
      }

    )
  }


}
