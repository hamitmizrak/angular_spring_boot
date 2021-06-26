import { Product } from './Product';
import { RegisterService } from './../services/register/register.service';
import { ToastrService } from 'ngx-toastr';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal'; //Bootstrap Modal ==> TemplateRef

import { ConfirmationService } from 'primeng/api'; //primeNg
import { NgForm } from '@angular/forms'; //form

declare let alertify: any;

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {
  //bootstrap modal
  requiredName: string = 'Adınızı girmediniz';
  requiredSurname: string = 'Soyadınız girmediniz';
  requiredEmail: string = 'Emailini girmediniz';
  requiredPassword: string = 'Şifrenizi girmediniz';

  //Product instance
  //import { Product } from './Product';
  //product: Product = new Product();

  //DETAY
  details(id: number) {
    this.registerService.getRegisterDetails(id).subscribe(
      (responseDetails) => {
        //Null
        if (responseDetails) {
          // this.toastr.info('Ekleme', 'Data eklendi');
          //console.log(form.value);
          console.log(responseDetails);
        }
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  //CREATE
  public productAddForm(form: NgForm): void {
    //alertify.success(form.value.name);
    //alertify.success(form.value.surname);
    //alertify.success(form.value.email);
    //alertify.success(form.value.password);
    console.log('data5555:' + form.value.registerSurname);
    //document.getElementById('add-product-form')?.click();//   click();
    this.registerService.getRegisterPost(form.value).subscribe(
      (responseCreate: Product) => {
        //Null
        if (responseCreate) {
          // this.toastr.info('Ekleme', 'Data eklendi');
          //console.log(form.value);
          console.log(responseCreate);
        }
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  //DELETE
  confirm(id: number) {
    this.confirmationService.confirm({
      message: 'Silmek istediğinizden emin misiniz?',
      accept: () => {
        console.log('siliniyor ' + 'id: ' + id);
        this.registerService
          .getRegisterDelete(id)
          .subscribe((responseDelete) => {
            if (responseDelete) {
              this.toastr.error('Silindi', 'Data Silindi');
            }
          });
      },
    });
  }

  //datatables
  data: any;
  constructor(
    private http: HttpClient, //Http
    private toastr: ToastrService, //Message
    private registerService: RegisterService,
    private modalService: BsModalService, //Bootstrap
    private confirmationService: ConfirmationService //PrimeNG
  ) {
    this.registerService.getRegisterAllList().subscribe((responseGet) => {
      // console.log(responseGet);
      this.data = responseGet;
      //console.log(this.data);
      //this.toastr.success('Select', 'Listelendi');
      // this.toastr.info('Select', 'Listelendi');
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

  //Bootstrap Modal
  modalRef: BsModalRef;
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  ngOnInit(): void {}
}
