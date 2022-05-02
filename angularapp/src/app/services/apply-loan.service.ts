import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Loan } from '../loan';
import { UserAuthServiceService } from './user-auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class ApplyLoanService {

  constructor(private http: HttpClient, private userAuthService:UserAuthServiceService) { }

  token:any=this.userAuthService.getToken();
  newToken=this.token.replace(/['"]+/g, '')

  loanId=this.userAuthService.getLoanId();

  public applyForLoan(loan: Loan):Observable<any>{
    console.log("clicking")
    return this.http.post<any>("https://8080-dffeebcffadededbccaaaccbedcbadfbddbcdbd.examlyiopb.examly.io/user/addLoan", loan, {
      headers: new HttpHeaders({
        Authorization: `Bearer ${this.newToken}`
      })
    })
        .pipe(catchError(this.errorHandler))
  }

  errorHandler(error:HttpErrorResponse){
    return throwError(error || 'Server Error');
  }
}
