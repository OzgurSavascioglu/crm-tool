import { Component,OnInit } from '@angular/core';
import { CustomerModel } from '../../models/customerModel';
import { HttpClient } from '@angular/common/http';
import { CustomerResponseModel } from '../../models/customerResponseModel';
import { CustomerService } from '../../services/customer.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-customer',
  standalone: false,
  templateUrl: './customer.html',
  styleUrl: './customer.css'
})
export class Customer implements OnInit {
  customers: CustomerModel []=[]
  dataLoaded=false;
  filterText: string = "";
  constructor(private customerService:CustomerService, private activatedRoute:ActivatedRoute){}

  ngOnInit():void{
    this.activatedRoute.params.subscribe(params=>{
      if(params["id"]){
        if(params["id"]==5){
          this.getActiveCustomers();
        }else{
          this.getCustomers();
        }
      }
      
      else{
        this.getCustomers();
      }
    })
  }



  getCustomers(){
    this.customerService.getCustomers().subscribe(response=>{
      this.customers=response.data
      this.dataLoaded=true;
    })
  }

  getActiveCustomers(){
    this.customerService.getActiveCustomers().subscribe(response=>{
      this.customers=response.data
      this.dataLoaded=true;
    })
  }

  editCustomer(customer:CustomerModel){
    console.log(customer);

  }
  deleteCustomer(customer:CustomerModel){
    console.log(customer);
  }
}
