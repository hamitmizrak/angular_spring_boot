import { HttpClient } from '@angular/common/http';
import { RegisterService } from './../../services/register/register.service';
import { Component, OnInit } from '@angular/core';

declare let alertify: any; //alertify
declare let $: any; //jquery
declare let jQuery: any; //jQuery

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  //datatables
  data: any;
  constructor(
    private registerService: RegisterService,
    private http: HttpClient
  ) {
    //get request from web api
  }

  ngOnInit(): void {
    //getAllList
    //data: any;
    this.registerService.getRegisterAllList().subscribe((responseGet) => {
     // console.log(responseGet);
      this.data = responseGet;
      console.log(this.data);
      setTimeout(() => {
        $('#datatableexample').DataTable({
          pagingType: 'full_numbers',
          pageLength: 5,
          processing: true,
          lengthMenu: [5, 10, 25],
        });
      }, 1);
    });

    //get request from web api
  }
}
