import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CustomerResponseModel } from '../models/customerResponseModel';
import { CustomerModel } from '../models/customerModel';
import { Observable } from 'rxjs';
import { ListResponseModel } from '../models/listResponseModel';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customers: CustomerModel []=[]
  apiUrl="http://localhost:8080/api/customers/"
  constructor(private httpClient: HttpClient) { }
  
  getCustomers(): Observable<ListResponseModel<CustomerModel>> {
    let newPath = this.apiUrl + "getAll"
      return this.httpClient
      .get<ListResponseModel<CustomerModel>>(newPath)
    }

  getActiveCustomers(): Observable<ListResponseModel<CustomerModel>> {
    let newPath = this.apiUrl + "getActive"
      return this.httpClient
      .get<ListResponseModel<CustomerModel>>(newPath)
    }

  getCustomersById(id:number): Observable<ListResponseModel<CustomerModel>> {
    let newPath = this.apiUrl + "getById/"+id
      return this.httpClient
      .get<ListResponseModel<CustomerModel>>(newPath)
    }

    add(customer:CustomerModel): Observable<CustomerResponseModel> {  
      return this.httpClient.post<CustomerResponseModel>(this.apiUrl+"add",customer)
    } 

    update(customer:CustomerModel): Observable<CustomerResponseModel> {  
      return this.httpClient.put<CustomerResponseModel>(this.apiUrl+"update",customer)
    }

    delete(id:number): Observable<void> {  
        let newPath = this.apiUrl + "softDelete/"+id    
        return this.httpClient.delete<void>(newPath)
      }
}
