import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewvendorComponent } from './viewvendor/viewvendor.component';
import { LoginComponent } from './login/login.component';
import { AddvendorComponent } from './addvendor/addvendor.component';


const routes: Routes = [

  { path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: 'login', component: LoginComponent },
  { path: 'viewvendor', component: ViewvendorComponent },
  { path: 'addvendor', component: AddvendorComponent },
  { path: 'addvendor/:vendorId', component: AddvendorComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
