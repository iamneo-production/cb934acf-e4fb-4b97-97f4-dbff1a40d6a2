import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { User } from 'src/app/user';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  msg=''
  user=new User()
  error=false
  constructor(private router:Router, private loginService:LoginServiceService) { }

  ngOnInit(): void {}

  signup(){
    this.router.navigateByUrl("register")
  }

  onSubmit(){
    this.loginService.loginUserFromRemoteServer(this.user).subscribe(
      data=>{
        console.log("response received")
      },
      error=>{
        console.log("exception occured")
        this.error=true
        this.msg="Invalid Credentials !! Please Enter valid EmailId and Password"
      }
    );
  }
}
