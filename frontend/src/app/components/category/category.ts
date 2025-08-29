import { Component } from '@angular/core';
import { CategoryModel } from '../../models/categoryModel';

@Component({
  selector: 'app-category',
  standalone: false,
  templateUrl: './category.html',
  styleUrl: './category.css'
})
export class Category {
  currentCategory: CategoryModel= {id:0, name:""};
  categories: CategoryModel[] = [
    //{id:1, name:"Add Customer"},
    //{id:2, name:"Update Customer"},
    //{id:3, name:"Delete Customer"},
    //{id:4, name:"View All Customers"},
    {id:5, name:"Active Customers"},
    //{id:6, name:"Search Customer"},
    //{id:7, name:"Deactivate Customer"},
  ];
 /*  categories: String[] = [
    'Add Customer', 'Update Customer', 'Delete Customer', 
    'View All Customers', 
    'View Active Customers',
    'Search Customer', 'Deactivate Customer',
  ]; */
    
  constructor() { }

  ngOnInit(): void {
    
  }

  setCurrentCategory(category:CategoryModel) {
    console.log(category);
    this.currentCategory = category;
  }

  getCurrentCategoryClass(category:CategoryModel) {
    if(category == this.currentCategory) {
      return "list-group-item active";
    } else {
      return "list-group-item";
    }
  }

  getAllCustomersClass() {
    if(this.currentCategory.id == 0) {
      return "list-group-item active";
    } else {
      return "list-group-item";
    }
  }

}
