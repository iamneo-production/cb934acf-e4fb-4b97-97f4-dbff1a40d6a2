import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from "@angular/forms";

@Component({
  selector: 'app-apply-loan',
  templateUrl: './apply-loan.component.html',
  styleUrls: ['./apply-loan.component.css']
})
export class ApplyLoanComponent implements OnInit {

  documents:string[]=['JPEG','PNG','PDF','DOC or DOCX'];
  // default:string ="Select the document type";
  applyLoan:FormGroup;
  step :any = 1;

  constructor() {
    this.applyLoan = new FormGroup({
      firstPage: new FormGroup({
        applicantName: new FormControl(null,[Validators.required,Validators.pattern('[a-zA-Z]*')]),
        applicantPanNo:new FormControl(
          null,
          [
            Validators.required,Validators.pattern('[A-Z]{3}[ABCFGHLJPTF]{1}[A-Z]{1}[0-9]{4}[A-Z]{1}')
          ]
        ),
        applicantAddress: new FormControl(null,[Validators.required]),
        applicantSalary: new FormControl(
          null,
          [
            Validators.required,Validators.pattern('^(?:0|[1-9]\\d*)(?:\\.(?!.*000)\\d+)?$')
          ]
        ),
        applicantMobileNo: new FormControl(
          null,
          [
            Validators.required,Validators.pattern('^(\\+\\d{1,2}\\s?)?1?\\-?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$')
          ]
        ),
        loanAmount:new FormControl(
          null,
          [
            Validators.required,Validators.pattern('^(?:0|[1-9]\\d*)(?:\\.(?!.*000)\\d+)?$')
          ]
        ),
        applicantEmailId:new FormControl(null,[Validators.required,Validators.email]),
        loanRepaymentMonth: new FormControl(null,[Validators.required]),
        applicantAadharNo: new FormControl(
          null,
          [
            Validators.required,Validators.pattern('(^[0-9]{4}[0-9]{4}[0-9]{4}$)|(^[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}$)|(^[0-9]{4}-[0-9]{4}-[0-9]{4}$)')
          ]
        ),
      }),
      secondPage: new FormGroup({
        document:new FormControl(null,[Validators.required]),
        file: new FormControl(null,[Validators.required]),
      })
    }
  );
  }


  ngOnInit(): void {

  }

  welcome:number = 0;
  getLoanFormData(){

    if(this.applyLoan.controls['firstPage'].invalid && this.step == 1){
      this.applyLoan.controls['firstPage'].markAllAsTouched();//so that empty field error message will be display when click on the  submit button
      return;//for disabling the button untill all field are field
    }
    if(this.applyLoan.controls['secondPage'].invalid && this.step == 2){
      this.applyLoan.controls['secondPage'].markAllAsTouched();//so that empty field error message will be display when click on the  submit button
      return;//for disabling the button untill all field are field
    }
    this.step = this.step + 1;
    if(this.step == 3){
      this.welcome = 1;
    }
  }

  previous(){
    this.step = this.step -1;
  }

  get applicantName(){
    return this.applyLoan.get('firstPage.applicantName');
  }

  get applicantPanNo(){
  return this.applyLoan.get('firstPage.applicantPanNo');
}

get applicantAddress(){
  return this.applyLoan.get('firstPage.applicantAddress');
}

get applicantSalary(){
  return this.applyLoan.get('firstPage.applicantSalary');
}

get applicantMobileNo(){
  return this.applyLoan.get('firstPage.applicantMobileNo');
}

get loanAmount(){
  return this.applyLoan.get('firstPage.loanAmount');
}

get applicantEmailId(){
  return this.applyLoan.get('firstPage.applicantEmailId');
}
get loanRepaymentMonth(){
  return this.applyLoan.get('firstPage.loanRepaymentMonth');
}
get applicantAadharNo(){
  return this.applyLoan.get('firstPage.applicantAadharNo');
}
get document(){
  return this.applyLoan.get('secondPage.document');
}
get file(){
  return this.applyLoan.get('secondPage.file');
}


}
