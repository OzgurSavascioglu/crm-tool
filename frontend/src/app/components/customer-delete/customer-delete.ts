import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { ActivatedRoute } from '@angular/router';
import { Customer } from '../customer/customer';

@Component({
  selector: 'app-customer-delete',
  standalone: false,
  templateUrl: './customer-delete.html',
  styleUrl: './customer-delete.css'
})
export class CustomerDelete {
  numberId: number = 0;
  constructor(private customerService: CustomerService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.numberId = Number(id);
    console.log(id);}

  delete(){
    if (this.numberId !== 0) {
      this.customerService.delete(this.numberId).subscribe(()=>{
        console.log("Customer deactivated");  
        //this.toastrService.success(response.message,"Success");
        }           , responseError=>{console.log(responseError);
          //this.toastrService.error(responseError.error);  
      })
    }       
  } 

}
