import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Loan } from 'src/app/loan';
import { ApplyLoanService } from 'src/app/services/apply-loan.service';
import { LoginServiceService } from 'src/app/services/login-service.service';
import { UserAuthServiceService } from 'src/app/services/user-auth-service.service';

@Component({
  selector: 'app-customerapplyloan',
  templateUrl: './customerapplyloan.component.html',
  styleUrls: ['./customerapplyloan.component.css']
})
export class CustomerapplyloanComponent implements OnInit {

  loan=new Loan()
  selectedType:string='';
  type=true;
  name=true;
  fileName:string='';
  msg:any={}
  err=false

  constructor(private userAuthService:UserAuthServiceService, private router:Router, private laonService:ApplyLoanService,
    private loginService:LoginServiceService) {

   }

  ngOnInit(): void {
  }

  loanForm=new FormGroup(
    {
      'applicantName':new FormControl('',[Validators.required, Validators.pattern("^[A-Za-z ]+$")]),
      'applicantAddress':new FormControl('',[Validators.required, Validators.maxLength(30)]),
      'applicantMobile':new FormControl('',[Validators.required,Validators.minLength(10),Validators.maxLength(10), Validators.pattern("^[6-9][0-9]+$")]),
      'applicantEmail':new FormControl('',[Validators.required, Validators.email]),
      'applicantAadhar':new FormControl('',[Validators.required, Validators.minLength(12), Validators.maxLength(12), Validators.pattern("^[1-9][0-9]+$")]),
      'applicantPan':new FormControl('',[Validators.required, Validators.pattern("^([A-Z]){5}([0-9]){4}([A-Z]){1}$")]),
      'applicantSalary':new FormControl('',[Validators.required, Validators.pattern("^[1-9][0-9]+$")]),
      'loanAmountRequired':new FormControl('',[Validators.required, Validators.pattern("^[1-9][0-9]+$")]),
      'selectItemList':new FormControl('',[Validators.required])
    }
  )

  get applicantName(){
    return this.loanForm.get('applicantName')
  }

  get applicantAddress(){
    return this.loanForm.get('applicantAddress')
  }

  get applicantMobile(){
    return this.loanForm.get('applicantMobile')
  }

  get applicantEmail(){
    return this.loanForm.get('applicantEmail')
  }

  get applicantAadhar(){
    return this.loanForm.get('applicantAadhar')
  }

  get applicantPan(){
    return this.loanForm.get('applicantPan')
  }

  get applicantSalary(){
    return this.loanForm.get('applicantSalary')
  }

  get loanAmountRequired(){
    return this.loanForm.get('loanAmountRequired')
  }

  get selectItemList(){
    return this.loanForm.get('selectItemList')
  }

  selectChangeHandler(event:any){
    this.selectedType=event.target.value;
    console.log(this.selectedType)
    if(this.selectedType===null || this.selectedType===''){
      this.type=!this.type
    }
  }

  save(event:any){
    let selectFile=event.target.files[0]
    this.fileName=selectFile.name
    console.log(this.fileName)
    if(this.fileName===null || this.fileName===''){
      this.name=!this.name
    }
  }

  public logout(){
    this.userAuthService.clearLocalStorage();
    this.router.navigateByUrl("user/login");
  }

  addLoan(){
    this.router.navigateByUrl("user/addLoan");
  }

  loanStatus(){
    this.router.navigateByUrl("user/viewLoan");
  }

  public applyLoan(){
    this.laonService.applyForLoan(this.loan).subscribe(data=>{
      console.log(data)
      this.userAuthService.setLoanId(JSON.stringify(data.loanId));
      this.router.navigateByUrl("user/loanApplied", {skipLocationChange:true});
    },
    error=>{
      console.log(error)
      this.err=true
      this.msg=error.error
    }
    )
  }
}
