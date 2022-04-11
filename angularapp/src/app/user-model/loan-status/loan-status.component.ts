import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from "@angular/forms";

@Component({
  selector: 'app-loan-status',
  templateUrl: './loan-status.component.html',
  styleUrls: ['./loan-status.component.css']
})
export class LoanStatusComponent implements OnInit {

  loanStatus:FormGroup;
  constructor() {
    this.loanStatus = new FormGroup({
      loanId: new FormControl(null,[Validators.required,Validators.pattern('^[1-9]\\d*$')]),
    });
  }

  ngOnInit(): void {
  }

  con:any = 0;
  getLoanStatusFormData(){
    if(this.loanStatus.invalid){
      this.loanStatus.markAllAsTouched();
      return;
    }
    this.con = 1;
  }

  get loanId(){
    return this.loanStatus.get('loanId');
  }

}
