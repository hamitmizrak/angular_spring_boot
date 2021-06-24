import { DataTablesModule } from 'angular-datatables';
import { BrowserModule } from '@angular/platform-browser';
import { RegisterService } from './../../services/register/register.service';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegisterRoutingModule } from './register-routing.module';
import { RegisterComponent } from './register.component';

@NgModule({
  declarations: [RegisterComponent],
  imports: [
    CommonModule,
    RegisterRoutingModule,
    BrowserModule,
    CommonModule,
    DataTablesModule,
  ],
  providers: [RegisterService],
})
export class RegisterModule {}
