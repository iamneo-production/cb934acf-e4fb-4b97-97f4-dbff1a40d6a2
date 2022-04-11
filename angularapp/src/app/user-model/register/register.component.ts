import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { CustomValidationService } from 'src/app/services/custom-validation.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  providers: [CustomValidationService]
})
export class RegisterComponent implements OnInit {

  role:string[] = ['User','Admin'];
  default:string = 'User';
  registerForm:FormGroup;

  constructor(private router:Router,private passwordValidator:CustomValidationService) {
    this.registerForm = new FormGroup({
      role: new FormControl(null),
      emailId:new FormControl(null,[Validators.required,Validators.email]),
      userName: new FormControl(null,[Validators.required,Validators.pattern('[a-zA-Z]*')]),
      mobileNumber: new FormControl(
        null,
        [
          Validators.required,Validators.pattern('^(\\+\\d{1,2}\\s?)?1?\\-?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$')
        ]
      ),
      password:new FormControl(
        null,
        [
          Validators.required,Validators.pattern("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$")
        ]
      ),
      confirmPassword:new FormControl(null,[Validators.required]),
    },
    {
      validators: this.passwordValidator.passwordMatchValidator("password","confirmPassword") //for confirmPassword validation
    }
  );
    this.registerForm.controls['role'].setValue(this.default,{onlySelf:true});//for select
  }

  ngOnInit(): void {
  }

  getRegisterFormData(){
    if(this.registerForm.invalid){
      this.registerForm.markAllAsTouched();//so that empty field error message will be display when click on the  submit button
      return;//for disabling the button untill all field are field
    }
    console.warn(this.registerForm.value);
    this.router.navigate(["/user/addLoan"])
  }

  get roles(){
    return this.registerForm.get('role');
  }

  get email(){
    return this.registerForm.get('emailId');
  }

  get userName(){
    return this.registerForm.get('userName');
  }

  get mobile(){
    return this.registerForm.get('mobileNumber');
  }

  get password(){
    return this.registerForm.get('password');
  }

  get confirmPassword(){
    return this.registerForm.get('confirmPassword');
  }
}
