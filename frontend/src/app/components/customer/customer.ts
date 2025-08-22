import { Component,OnInit } from '@angular/core';
import { CustomerModel } from '../../models/customerModel';
import { HttpClient } from '@angular/common/http';
import { CustomerResponseModel } from '../../models/customerResponseModel';

@Component({
  selector: 'app-customer',
  standalone: false,
  templateUrl: './customer.html',
  styleUrl: './customer.css'
})
export class Customer implements OnInit {
  customers: CustomerModel []=[]
  apiUrl="http://localhost:8080/api/customers/getAll"

  constructor(private httpClient: HttpClient){}

  ngOnInit():void{
    this.getCustomers();
  }

  getCustomers(){
    this.httpClient
    .get<CustomerResponseModel>(this.apiUrl)
    .subscribe(response=>{
      this.customers=response.data
    })
  }
}
