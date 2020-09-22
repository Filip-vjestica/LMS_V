import { Injectable } from '@angular/core';
import { CanActivate, CanActivateChild, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { LoginService } from '../login/login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthRouteService implements CanActivate, CanActivateChild {

  constructor(private loginService: LoginService,private router: Router) { }
  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | import("@angular/router").UrlTree | import("rxjs").Observable<boolean | import("@angular/router").UrlTree> | Promise<boolean | import("@angular/router").UrlTree> {
    try {
      for(let role of this.loginService.getLoggedInUser().roles){
        if(childRoute.data.allowedRoles == role['authority']){
          return true;
        }
      }
      
        return false;
    } catch (error) { 
      this.router.navigate(["/public-home"]);
    } 
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | import("@angular/router").UrlTree | import("rxjs").Observable<boolean | import("@angular/router").UrlTree> | Promise<boolean | import("@angular/router").UrlTree> {
    try {
      for(let role of this.loginService.getLoggedInUser().roles){
        if(route.data.allowedRoles == role['authority']){
          return true;
        }
      }
      this.router.navigate(["/public-home"]);
        return false;
    } catch (error) {  
      this.router.navigate(["/public-home"]);
    }
  }
}