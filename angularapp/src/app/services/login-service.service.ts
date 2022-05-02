import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http:HttpClient) { }

  public generateToken(user:User){
    return this.http.post("https://8080-dffeebcffadededbccaaaccbedcbadfbddbcdbd.examlyiopb.examly.io/user/login",user,{responseType: 'text' as 'json'})
  }

  public registerUserFormRemoteServer(user:User):Observable<any>{
    return this.http.post<any>("https://8080-dffeebcffadededbccaaaccbedcbadfbddbcdbd.examlyiopb.examly.io/user/signup",user)
      .pipe(catchError(this.errorHandler));
  }

  errorHandler(error:HttpErrorResponse){
    return throwError(error || 'Server Error');
  }
}
