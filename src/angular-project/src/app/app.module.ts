import { RegisterService } from './services/register/register.service';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService } from 'primeng/api';
import { ApisService } from './services/apis.service';
import { HttpClientModule } from '@angular/common/http';
import { DataTablesModule } from 'angular-datatables';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
//toastr
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule, ToastrService } from 'ngx-toastr';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnadizinComponent } from './anadizin/anadizin.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './account/login/login.component';
import { RegisterComponent } from './account/register/register.component';
import { CommonModule } from '@angular/common';
import { ProductComponent } from './product/product.component';
//modal
import { ModalModule } from 'ngx-bootstrap/modal'; //bootstrap modal
//Form
import { FormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    AnadizinComponent,
    PagenotfoundComponent,
    AboutComponent,
    LoginComponent,
    RegisterComponent,
    ProductComponent,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    CommonModule, //ngIf ngFor için
    AppRoutingModule, //routing
    DataTablesModule, //datatables
    HttpClientModule, //Http
    ModalModule.forRoot(), //Bootstrap modal
    BrowserAnimationsModule, // required animations module,
    ConfirmDialogModule, //primeNg
    ToastrModule.forRoot({
      timeOut: 3000,
      progressBar: true,
      progressAnimation: 'increasing',
      closeButton: true,
      //"positionClass": "toast-bottom-left",
      positionClass: 'toast-top-right',
    }), // ToastrModule added
  ],
  providers: [ApisService, ConfirmationService, RegisterService], //primeNg
  bootstrap: [AppComponent],
})
export class AppModule {}
