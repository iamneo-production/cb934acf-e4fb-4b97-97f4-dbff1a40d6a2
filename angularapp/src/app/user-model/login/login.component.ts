import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { FormControl, FormGroup, Validators } from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }


  loginForm = new FormGroup({
    emailId:new FormControl('',[Validators.required,Validators.email]),
    password:new FormControl(
      null,
      [
        Validators.required,Validators.pattern("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$")
      ]
    )
  })

  getUserFormData(){
    if(this.loginForm.invalid){
      this.loginForm.markAllAsTouched();//so that empty field error message will be display when click on the  submit button
      return;//for disabling the button untill all field are field
    }
    console.warn(this.loginForm.value);
    this.router.navigate(["/user/addLoan"])
  }

  get email(){
    return this.loginForm.get('emailId');
  }

  get password(){
    return this.loginForm.get('password');
  }

}
