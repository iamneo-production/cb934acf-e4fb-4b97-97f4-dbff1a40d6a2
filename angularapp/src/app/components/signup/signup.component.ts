import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  msg:any={}
  user=new User()
  err=false

  constructor(private router:Router, private loginService:LoginServiceService) { }

  ngOnInit(): void {}

  onSignup(){
    this.loginService.registerUserFromRemoteServer(this.user).subscribe(
      data=>{
        console.log("Registration Successful")
        this.router.navigateByUrl("login");
      },
      error=>{
        console.log("Registration Unsuccessful")
        this.err=true
        this.msg=error.error
      }
    )
  }

  login(){
    this.router.navigateByUrl("login");
  }

}
