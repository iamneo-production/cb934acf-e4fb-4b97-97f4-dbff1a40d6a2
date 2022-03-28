import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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

  constructor(
    private router:Router, private loginService:LoginServiceService
  ) { }

  ngOnInit(): void {}

  exform=new FormGroup({
    'name':new FormControl('',[Validators.required, Validators.pattern("^[A-Za-z]+$")]),
    'username':new FormControl('',Validators.required),
    'email':new FormControl('',[Validators.required, Validators.email]),
    'phone':new FormControl ('', [Validators.required, Validators.pattern("^[6-9][0-9]+$"), Validators.minLength(10), Validators.maxLength(10)]),
    'password':new FormControl('',[Validators.required, Validators.maxLength(20), Validators.minLength(8)])
  })

  get name(){
    return this.exform.get('name')
  }

  get username(){
    return this.exform.get('username')
  }

  get email(){
    return this.exform.get('email')
  }

  get phone(){
    return this.exform.get('phone')
  }

  get password(){
    return this.exform.get('password')
  }

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
