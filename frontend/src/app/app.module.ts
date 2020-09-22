import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';




import { FormsModule } from '@angular/forms';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AuthInterceptor } from './auth.interceptor';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FakultetiComponent } from './fakulteti/fakulteti.component';
import { UniverzitetComponent } from './univerzitet/univerzitet.component';
import { ProfilComponent } from './profil/profil.component';
import { KorisniciComponent } from './korisnici/korisnici.component';
import { PredmetiComponent } from './predmeti/predmeti.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    FakultetiComponent,
    UniverzitetComponent,
    ProfilComponent,
    KorisniciComponent,
    PredmetiComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true},],
  bootstrap: [AppComponent]
})
export class AppModule { }
