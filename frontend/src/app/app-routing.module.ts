import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FakultetiComponent} from './fakulteti/fakulteti.component';
import { UniverzitetComponent } from './univerzitet/univerzitet.component';
import { KorisniciComponent } from './korisnici/korisnici.component';
import {PredmetiComponent} from './predmeti/predmeti.component';




const routes: Routes = [
  {
    path: '',
    component:UniverzitetComponent,
  },
  {
    path: '*',
    component: UniverzitetComponent,
  },
  {
    path: 'univerzitet',
    component: UniverzitetComponent,  
  },
  { path: 'login', component: LoginComponent},
  {
    path: 'register',
    component: RegisterComponent,
    
  },
  {
    path: 'fakulteti',
    component: FakultetiComponent,
    
  },
  {
    path: 'korisnici',
    component: KorisniciComponent,
    
  },
  {
    path: 'predmeti',
    component: PredmetiComponent,
    
  }
  
  
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
