import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthServiceService } from 'src/app/services/user-auth-service.service';

@Component({
  selector: 'app-adminappliedloan',
  templateUrl: './adminappliedloan.component.html',
  styleUrls: ['./adminappliedloan.component.css']
})
export class AdminappliedloanComponent implements OnInit {

  getAllLoans:any=[
    {
      applicantAadhar:'xxxx',
      applicantAddress:'xxxx',
      applicantEmail:'a@gmail.com',
      applicantMobile:'8795569945',
      applicantName:'Arul',
      applicantPan:'xxxx',
      loanAmountRequired:'400000',
      loanId:1
    },
    {
      applicantAadhar:'xxxx',
      applicantAddress:'xxxx',
      applicantEmail:'b@gmail.com',
      applicantMobile:'9795569945',
      applicantName:'Akash',
      applicantPan:'xxxx',
      loanAmountRequired:'200000',
      loanId:2
    },
    {
      applicantAadhar:'xxxx',
      applicantAddress:'xxxx',
      applicantEmail:'c@gmail.com',
      applicantMobile:'7795569945',
      applicantName:'Ayushi',
      applicantPan:'xxxx',
      loanAmountRequired:'150000',
      loanId:3
    },
    {
      applicantAadhar:'xxxx',
      applicantAddress:'xxxx',
      applicantEmail:'c@gmail.com',
      applicantMobile:'7795569945',
      applicantName:'Ayushi',
      applicantPan:'xxxx',
      loanAmountRequired:'150000',
      loanId:3
    },
    {
      applicantAadhar:'xxxx',
      applicantAddress:'xxxx',
      applicantEmail:'c@gmail.com',
      applicantMobile:'7795569945',
      applicantName:'Ayushi',
      applicantPan:'xxxx',
      loanAmountRequired:'150000',
      loanId:3
    }
  ]

  constructor(private router:Router, private userAuthService:UserAuthServiceService) { }

  ngOnInit(): void {
  }
  
  public logout(){
    this.userAuthService.clearLocalStorage();
    this.router.navigateByUrl("admin/login");
  }
  viewLoan(){
    this.router.navigateByUrl("admin/viewLoan");
  }
  trackLoan(){
    this.router.navigateByUrl("admin/trackLoan");
  }
  approveLoan(){
    this.router.navigateByUrl("admin/viewLoan");
  }

  rejectLoan(){
    this.router.navigateByUrl("admin/viewLoan");
  }

}
