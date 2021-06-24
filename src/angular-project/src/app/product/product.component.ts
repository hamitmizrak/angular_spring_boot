import { RegisterService } from './../services/register/register.service';
import { ToastrService } from 'ngx-toastr';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {
  //datatables
  data: any;
  constructor(
    private http: HttpClient,
    private toastr: ToastrService,
    private registerService: RegisterService
  ) {
    this.registerService.getRegisterAllList().subscribe((responseGet) => {
      // console.log(responseGet);
      this.data = responseGet;
      console.log(this.data);
      //this.toastr.success('Select', 'Listelendi');
      this.toastr.info('Select', 'Listelendi');
      //this.toastr.warning('Başlık', 'İçerikler');
      //this.toastr.error('Başlık', 'İçerikler');
      setTimeout(() => {
        $('#datatableexample').DataTable({
          pagingType: 'full_numbers',
          pageLength: 5,
          processing: true,
          lengthMenu: [5, 10, 15, 20, 25, 50, 100, 250],
        });
      }, 1);
    });
  }

  ngOnInit(): void {}
}
