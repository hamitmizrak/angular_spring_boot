import { ProductComponent } from './product/product.component';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { ContactComponent } from './blog/contact/contact.component';
//import { RegisterComponent } from './blog/register/register.component';
//jwt
import { RegisterComponent } from './jwt/register/register.component';
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
  { path: 'urun', component: ProductComponent },
  //{ path: '**', component: PagenotfoundComponent },
  {
    path: 'create',
    children: [
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
    ],
  },
  {
    path: 'blog',
    children: [
      { path: 'contact', component: ContactComponent },
      { path: 'register', component: RegisterComponent },
    ],
  },

  {
    path: 'jwt',
    children: [
      { path: 'jwtRegister', component: RegisterComponent },
      { path: 'register', component: RegisterComponent },
    ],
  },

  {
    path: 'iletisim',
    loadChildren: () =>
      import('./blog/contact/contact.module').then((il) => il.ContactModule),
  },
];
@NgModule({
  imports: [
    RouterModule.forRoot(
      routes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    CommonModule,
    BrowserModule,
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}
