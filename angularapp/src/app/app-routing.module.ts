import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuardGuard } from './guards/auth-guard.guard';

const routes: Routes = [
  {
    path:'',
    redirectTo:'user/login',
    pathMatch:'full'
  },
  {
    path:'user/login',
    loadChildren: () => import('./components/login/login.module').then(m => m.LoginModule)
  },
  {
    path:'user/signup',
    loadChildren: () => import('./components/signup/signup.module').then(m => m.SignupModule)
  },
  {
    path:'user/addLoan',
    loadChildren:()=>import('./components/customerapplyloan/customerapplyloan.module').then(m=>m.CustomerapplyloanModule),
    canActivate:[AuthGuardGuard]
  },
  {
    path:'user/loanApplied',
    loadChildren:()=>import('./components/loan-id/loan-id.module').then(m=>m.LoanIdModule),
    canActivate: [AuthGuardGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
