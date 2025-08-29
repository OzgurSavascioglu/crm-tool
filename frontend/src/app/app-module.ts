import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Navi } from './components/navi/navi';
import { Category } from './components/category/category';
import { Customer } from './components/customer/customer';
import { NameLengthAddedPipe } from './pipes/name-length-added-pipe';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FilterPipePipe } from './pipes/filter-pipe-pipe';
import { CustomerAdd } from './components/customer-add/customer-add';
import { ToastrModule} from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CustomerEdit } from './components/customer-edit/customer-edit';
import { CustomerDelete } from './components/customer-delete/customer-delete';


@NgModule({
  declarations: [
    App,
    Navi,
    Category,
    Customer,
    NameLengthAddedPipe,
    FilterPipePipe,
    CustomerAdd,
    CustomerEdit,
    CustomerDelete
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      positionClass:"toast-bottom-right"
    }),
    ReactiveFormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners()
  ],
  bootstrap: [App]
})
export class AppModule { }
