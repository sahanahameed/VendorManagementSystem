import { Component, OnInit } from '@angular/core';
import { Login } from '../login';
import { Router } from '@angular/router';
import { AuthService } from '../authservice.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  login = new Login();

  constructor(private router: Router, private _authservice: AuthService) { }

  ngOnInit() {

    this.resetForm()
    
  }

  resetForm(form?: NgForm) {
    if (form != null)
      form.resetForm();
    this._authservice.formData = {

      userId: null,
      username: '',
      password: ''
    }
  }
  OnSubmit(form: NgForm) {
    console.log("My form : " + form);
    this.loginUser(form);
  }

  loginUser(form: NgForm) 
  {
      console.log(form.value);
      this._authservice.verifyUser(form.value).subscribe((userData) => {
      this.login = userData;
      console.log(this.login);
      var username = this.login.username;
      var password = this.login.password;
      console.log(userData);
      
      if(this.login.userId == 6)
      {
        this.router.navigate(['viewvendor']);
      }
      else
      {
        this.router.navigate(['viewvendor']);
      }

    }, (error) => {
      console.log(error);
    });
  }
}
