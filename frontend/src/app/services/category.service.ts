import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ListResponseModel } from '../models/listResponseModel';
import { Observable } from 'rxjs';
import { CategoryModel } from '../models/categoryModel';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  categories: CategoryService []=[]
  apiUrl="http://localhost:8080/api/categories/getAll"
  constructor(private httpClient: HttpClient) { }
  
  getCustomers(): Observable<ListResponseModel<CategoryModel>> {
      return this.httpClient
      .get<ListResponseModel<CategoryModel>>(this.apiUrl)
    }
}
