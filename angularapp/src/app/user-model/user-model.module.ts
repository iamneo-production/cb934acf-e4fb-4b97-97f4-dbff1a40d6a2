import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserModelRoutingModule } from './user-model-routing.module';
import { ApplyLoanComponent } from './apply-loan/apply-loan.component';
import { LoanStatusComponent } from './loan-status/loan-status.component';
import { LoginComponent } from './login/login.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { RegisterComponent } from './register/register.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [ApplyLoanComponent, LoanStatusComponent, LoginComponent, NavBarComponent, RegisterComponent, UserProfileComponent],
  imports: [
    CommonModule,
    UserModelRoutingModule,
    FormsModule,
    ReactiveFormsModule,
     
  ],
  exports: [
    LoginComponent,
    RegisterComponent,
    NavBarComponent,
    LoanStatusComponent,
    UserProfileComponent,
    ApplyLoanComponent
  ]
})
export class UserModelModule { }
