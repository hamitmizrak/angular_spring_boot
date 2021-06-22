import { RegisterComponent } from './account/register/register.component';
import { LoginComponent } from './account/login/login.component';
import { AboutComponent } from './about/about.component';
//import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { AnadizinComponent } from './anadizin/anadizin.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'anadizin', component: AnadizinComponent },
  { path: '', redirectTo: 'anadizin', pathMatch: 'full' },
  { path: 'about', component: AboutComponent },
  //{ path: '**', component: PagenotfoundComponent },

  {
    path: 'create',
    children: [
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
    ],
  },
];
@NgModule({
  imports: [
    RouterModule.forRoot(
      routes,
      { enableTracing: true } // <-- debugging purposes only
    ),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}
