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

  constructor(private httpClient:HttpClient) { }

  public loginUserFromRemoteServer(user:User):Observable<any>{
    return this.httpClient.post<any>("http://localhost:8080/user/login",user);
  }

  public registerUserFromRemoteServer(user:User):Observable<any>{
    return this.httpClient.post<any>("http://localhost:8080/user/signup",user)
      .pipe(catchError(this.errorHandler));
  }

  errorHandler(error:HttpErrorResponse){
    return throwError(error || 'Server Error')
  }
}
