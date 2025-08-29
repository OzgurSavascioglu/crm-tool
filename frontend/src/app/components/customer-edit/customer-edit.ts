import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { CustomerService } from '../../services/customer.service';
import { CustomerModel } from '../../models/customerModel';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-customer-edit',
  standalone: false,
  templateUrl: './customer-edit.html',
  styleUrl: './customer-edit.css'
})
export class CustomerEdit {
  customerEditForm : FormGroup =new FormGroup({
    id: new FormControl(),
    name:new FormControl(),
    email:new FormControl(),
    phone:new FormControl(),
    address:new FormControl(),
    companyName:new FormControl(),
    customerType:new FormControl(),
  });
  constructor(private formBuilder:FormBuilder, private customerService: CustomerService, 
    private toastrService: ToastrService,
  private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id !== null) {
      this.customerService.getCustomersById(+id).subscribe(customer => {
        this.customerEditForm.patchValue(customer);
      });
    } else {
      this.toastrService.error("Invalid customer ID", "Error");
    }
  } 

  createCustomerEditForm(customer:CustomerModel){
    this.customerEditForm=this.formBuilder.group({
      id:[customer.id, Validators.required],
      name:[customer.name,Validators.required],
      email:[customer.email,Validators.required],
      phone:[customer.phone,Validators.required],
      address:[customer.address,Validators.required],
      companyName:[customer.companyName,Validators.required],
      customerType:[customer.customerType,Validators.required],
    })
  }

  edit(){
    console.log(this.customerEditForm);
    if(this.customerEditForm.valid){
      let customerModel=Object.assign({},this.customerEditForm.value)
      this.customerService.update(customerModel).subscribe(response=>{
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
