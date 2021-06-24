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

  private lOCAL_PATH = 'register/get/list';

  //GET
  //http://localhost:9293/api/register/get/list
  getRegisterAllList(): Observable<any> {
    return this.apisService.getAllList(this.lOCAL_PATH).pipe(
      map((responseGet) => {
        if (responseGet) {
          alertify.success(responseGet + ' ');
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
  getRegisterDelete(): Observable<any> {
    return this.apisService.getDelete(this.lOCAL_PATH).pipe(
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
  getRegisterPost(): Observable<any> {
    return this.apisService.getPost(this.lOCAL_PATH).pipe(
      map((responsePost) => {
        if (responsePost) {
          alertify.success(responsePost + ' ');
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
