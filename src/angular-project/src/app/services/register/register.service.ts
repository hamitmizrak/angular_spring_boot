import { NgForm } from '@angular/forms';
import { Product } from './../../product/Product';
import { Observable } from 'rxjs';
import { ApisService } from './../apis.service';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
declare let alertify: any;

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  constructor(private apisService: ApisService) {}

  private lOCAL_PATH = 'register/';

  //GET/id
  //localhost:9293/api/register/get/14
  getRegisterDetails(id: number): Observable<any> {
    return this.apisService.getDetails(this.lOCAL_PATH + 'get/' + id).pipe(
      map((responseGetId) => {
        if (responseGetId) {
          //alertify.success(responseGet + ' ');
          return responseGetId;
        } else {
          alertify.error(responseGetId + ' ');
          console.log(responseGetId + '');
          return {};
        }
      })
    );
  }

  //GET
  //http://localhost:9293/api/register/get/list
  getRegisterAllList(): Observable<any> {
    return this.apisService.getAllList(this.lOCAL_PATH + 'get/list').pipe(
      map((responseGet) => {
        if (responseGet) {
          //alertify.success(responseGet + ' ');
          return responseGet;
        } else {
          alertify.error(responseGet + ' ');
          console.log(responseGet + '');
          return {};
        }
      })
    );
  }

  //DELETE
  //localhost:9293/api/register/delete/13
  getRegisterDelete(id: number): Observable<any> {
    return this.apisService.getDelete(this.lOCAL_PATH + 'delete/' + id).pipe(
      map((responseDelete) => {
        if (responseDelete) {
          alertify.success(responseDelete + ' ');
          return responseDelete;
        } else {
          alertify.error(responseDelete + ' ');
          console.log(responseDelete + '');
          return {};
        }
      })
    );
  }

  //POST ==>insert
  //localhost:9293/api/register/post
  //veri null oluyor.
  getRegisterPost(form: NgForm): Observable<any> {
    return this.apisService.getPost(this.lOCAL_PATH + 'post').pipe(
      map((responsePost) => {
        if (responsePost) {
          alertify.success(form.value + ' ');
          return responsePost;
        } else {
          alertify.error(responsePost + ' ');
          console.log(responsePost + '');
          return {};
        }
      })
    );
  }

  //PUT
  getRegisterPut(): Observable<any> {
    return this.apisService.getPut(this.lOCAL_PATH).pipe(
      map((responsePut) => {
        if (responsePut) {
          alertify.success(responsePut + ' ');
          return responsePut;
        } else {
          alertify.error(responsePut + ' ');
          console.log(responsePut + '');
          return {};
        }
      })
    );
  }
} //en code
