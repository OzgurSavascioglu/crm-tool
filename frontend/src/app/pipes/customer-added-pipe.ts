import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'customerAdded',
  standalone: false
})
export class CustomerAddedPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
