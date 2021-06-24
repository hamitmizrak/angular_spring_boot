import { environment } from './../../environments/environment';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { catchError } from 'rxjs/operators';

import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApisService {
  constructor(private http: HttpClient) {}

  //post ve put icin Headers
  httpConfigs = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  //RxJS:Reactive Programming : RxJS: stream üzerinden çalışıyor
  //Datalarımızı manipülasyon işlemlerine tabi tutarız
  //RxJS: fonksiyonlar (Operatörler) : observable veri olarak işlem yapılıyordu. subscribe(abone)

  //CRUD

  //http://localhost:9293/api/register/   get/list

  //GetList
  getAllList(
    path: string,
    params: HttpParams = new HttpParams()
  ): Observable<any> {
    return this.http
      .get(environment.CONFIG_URL_PATH + path, { params })
      .pipe(catchError(this.errorCatchFunction));
  }

  //delete
  getDelete(
    path: string,
    params: HttpParams = new HttpParams()
  ): Observable<any> {
    return this.http
      .delete(environment.CONFIG_URL_PATH + path, { params })
      .pipe(catchError(this.errorCatchFunction));
  }

  //post  ==> Header olmak zorunda
  getPost(
    path: string,
    params: HttpParams = new HttpParams()
  ): Observable<any> {
    return this.http
      .post(
        environment.CONFIG_URL_PATH + path,
        JSON.stringify(params),
        this.httpConfigs
      )
      .pipe(catchError(this.errorCatchFunction));
  }
  //put  ==> Header olmak zorunda
  getPut(path: string, params: HttpParams = new HttpParams()): Observable<any> {
    return this.http
      .put(
        environment.CONFIG_URL_PATH + path,
        JSON.stringify(params),
        this.httpConfigs
      )
      .pipe(catchError(this.errorCatchFunction));
  }

  //genel hataların handling yapildigi yer
  private errorCatchFunction(hata: any) {
    return of(hata.error);
  }
}
