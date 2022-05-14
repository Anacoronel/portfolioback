import { TokenService }  from './services/security/token.service';
import { NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutLangComponent } from './components/about-lang/about-lang.component';
import { EducExpComponent } from './components/educ-exp/educ-exp.component';
import { ProjSkillComponent } from './components/proj-skill/proj-skill.component';
import { PortfolioComponent } from './components/portfolio/portfolio.component';
import { ErrorComponent } from './components/error/error.component';
import { HeaderComponent } from './components/header/header.component';

import { ModalModule, BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { NgCircleProgressModule } from 'ng-circle-progress';
import {ReactiveFormsModule} from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { PersonService } from './services/person.service';
import { ProjSkillService } from './services/proj-skill.service';
import { AuthService } from './services/security/auth.service';
import { EducExpService } from './services/educ-exp.service';
import { AboutLangService } from './services/about-lang.service';
import { GuardsService } from './services/security/guards.service';
import { ToastrModule } from 'ngx-toastr';
import { InterceptorService } from './services/security/interceptor.service';
import { LoginComponent } from './components/login/login/login.component';
import { NewuserComponent } from '../app/components/login/newuser/newuser.component';







@NgModule({
  declarations: [
    AppComponent,
    AboutLangComponent,
    EducExpComponent,
    ProjSkillComponent,
    PortfolioComponent,
    LoginComponent,
    NewuserComponent,
    ErrorComponent,
    HeaderComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ModalModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),

    NgCircleProgressModule.forRoot({
      // set defaults here
      "radius": 34,
      "outerStrokeWidth": 9,
      "innerStrokeWidth": 9,
      "showBackground": false,
      "startFromZero": false,
      "showTitle": true,
      "space": -11.5,
      "showSubtitle": true,
      "subtitleFontSize": "12",
      "subtitleColor": "#2f535e",
      "titleFontSize": "10",
      "lazy": false,
      "backgroundStroke": 'transparent',
      "backgroundGradientStopColor": 'transparent',
    })


  
 
  ],
  providers: [PersonService, TokenService, BsModalService, BsModalRef, AuthService, ProjSkillService, EducExpService, AboutLangService, GuardsService,  {
    provide: HTTP_INTERCEPTORS, useClass: InterceptorService, multi: true
  } ],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
