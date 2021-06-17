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

  ngOnInit(): void {
    /*
    //jQuery
  $('#jQuery_button').click(function () {
    alertify.success("Jquery Çalışıyor");
    $('#jQuery_h1').css("color","red")
  });*/
  
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
}
