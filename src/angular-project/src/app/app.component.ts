import { ToastrService } from 'ngx-toastr';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
declare let alertify: any; //alertify

declare let $: any; //jquery
declare let jQuery: any; //jQuery

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'angular-project';

  isLoading: boolean = false;
  //downloading spinner
  //downloadingSpinner(){}
  downloadingSpinner = () => {
    this.isLoading = true;

    //zaman
    setTimeout(() => {
      this.isLoading = false;
    }, 4000);
  };

  ngOnInit(): void {
    /*
    //jQuery
  $('#jQuery_button').click(function () {
    alertify.success("Jquery Çalışıyor");
    $('#jQuery_h1').css("color","red")
  });
  */
  }

  //jQuery Click
  jQueryClickExamples() {
    alertify.success('Jquery Çalışıyor');
    $('#jQuery_h1').css('color', 'white');
    $('#jQuery_h1').css('background-color', 'black');
  }

  //alertify
  success() {
    alertify.error('oldu');
  }

  toascrShowSuccess() {
    this.toastr.success('Başlık', 'İçerikler');
    this.toastr.info('Başlık', 'İçerikler');
    this.toastr.warning('Başlık', 'İçerikler');
    this.toastr.error('Başlık', 'İçerikler');
  }

  //datatables
  data: any;
  constructor(private http: HttpClient, private toastr: ToastrService) {
    //get request from web api
    this.http.get('https://www.testjsonapi.com/users/').subscribe(
      (data) => {
        this.data = data;
        setTimeout(() => {
          $('#datatableexample').DataTable({
            pagingType: 'full_numbers',
            pageLength: 5,
            processing: true,
            lengthMenu: [5, 10, 25],
          });
        }, 1);
      },
      (error) => console.error(error)
    );
  }
}
