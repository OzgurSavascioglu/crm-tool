import { Pipe, PipeTransform } from '@angular/core';
import { CustomerModel } from '../models/customerModel';
import { filter } from 'rxjs';

@Pipe({
  name: 'filterPipe',
  standalone: false
})
export class FilterPipePipe implements PipeTransform {

  transform(value: CustomerModel [], filterText: string): CustomerModel [] {
    filterText=filterText?filterText.toLocaleLowerCase():"";
    return filterText?value
    .filter((c:CustomerModel)=>c.name.toLocaleLowerCase().indexOf(filterText)!==-1)
    :value;
  }

}
