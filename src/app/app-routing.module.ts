import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './components/error/error.component';
import { LoginComponent } from './components/login/login/login.component';
import { NewuserComponent } from './components/login/newuser/newuser.component';
import { PortfolioComponent } from './components/portfolio/portfolio.component';

const routes: Routes = [

  { path: '',  pathMatch: 'full', component:PortfolioComponent},
  {path:'portfolio', component: PortfolioComponent},
  { path: 'login', component: LoginComponent },
  { path: 'new', component: NewuserComponent },
  {path: '404', component: ErrorComponent},
  {path: '**', redirectTo: '404', pathMatch: 'full'}  



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
