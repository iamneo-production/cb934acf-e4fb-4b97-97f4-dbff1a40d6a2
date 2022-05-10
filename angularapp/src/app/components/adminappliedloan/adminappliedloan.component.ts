import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { UserAuthServiceService } from 'src/app/services/user-auth-service.service';

@Component({
  selector: 'app-adminappliedloan',
  templateUrl: './adminappliedloan.component.html',
  styleUrls: ['./adminappliedloan.component.css']
})
export class AdminappliedloanComponent implements OnInit {

  getAllLoans:any=[]

  constructor(private router:Router, private userAuthService:UserAuthServiceService, private adminService:AdminService) { }

  ngOnInit(): void {
    this.adminService.getAllLoan().subscribe(data=>{
      this.getAllLoans=data;
    },
    error=>console.log(error)
    )
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
