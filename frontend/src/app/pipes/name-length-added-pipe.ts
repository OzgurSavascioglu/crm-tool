import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'nameLengthAdded',
  standalone: false
})
export class NameLengthAddedPipe implements PipeTransform {

  transform(value: string): number {
    return value.length;
  }

}
