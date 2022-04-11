import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApplyLoanComponent } from './apply-loan/apply-loan.component';
import { LoanStatusComponent } from './loan-status/loan-status.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

const routes: Routes = [
  {
    path: 'user',children:[
      { path:'login',component:LoginComponent },
      { path:'signup',component:RegisterComponent },
      { path:'addLoan',component: ApplyLoanComponent },
      { path:'viewLoan',component: LoanStatusComponent },
      { path:'getProfile',component: UserProfileComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserModelRoutingModule { }
