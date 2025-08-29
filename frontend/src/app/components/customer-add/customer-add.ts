import { Component } from '@angular/core';
import {FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import { CustomerService } from '../../services/customer.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-customer-add',
  standalone: false,
  templateUrl: './customer-add.html',
  styleUrl: './customer-add.css'
})
export class CustomerAdd {

  customerAddForm : FormGroup =new FormGroup({
    name:new FormControl(),
    email:new FormControl(),
    phone:new FormControl(),
    address:new FormControl(),
    companyName:new FormControl(),
    customerType:new FormControl(),
  });

  constructor(private formBuilder:FormBuilder, private customerService: CustomerService, 
    private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.createCustomerAddForm();
  }

  createCustomerAddForm(){
    this.customerAddForm=this.formBuilder.group({
      name:["",Validators.required],
      email:["",Validators.required],
      phone:["",Validators.required],
      address:["",Validators.required],
      companyName:["",Validators.required],
      customerType:["",Validators.required],
    })
  }

  add(){
    console.log(this.customerAddForm);
    if(this.customerAddForm.valid){
      let customerModel=Object.assign({},this.customerAddForm.value)
      this.customerService.add(customerModel).subscribe(response=>{
        console.log(response);  
        this.toastrService.success(response.message,"Success");
        }, responseError=>{console.log(responseError);
          this.toastrService.error(responseError.error);  
      })
    }

    else{
    this.toastrService.error("Missing fields","Error");   
    }
  }

}
