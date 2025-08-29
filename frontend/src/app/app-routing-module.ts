import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Customer } from './components/customer/customer';
import { Category } from './components/category/category';
import { CustomerAdd } from './components/customer-add/customer-add';
import { CustomerEdit } from './components/customer-edit/customer-edit';
import { CustomerDelete } from './components/customer-delete/customer-delete';

const routes: Routes = [
  {path: "", pathMatch:"full", component:Customer},
  {path: "customers", component:Customer},
  {path: "customers/category/:id", component:Customer},
  {path: "customers/add", component: CustomerAdd},
  {path: "customers/edit/:id", component: CustomerEdit},
  {path: "customers/delete/:id", component: CustomerDelete},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
