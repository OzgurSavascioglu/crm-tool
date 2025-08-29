import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerDelete } from './customer-delete';

describe('CustomerDelete', () => {
  let component: CustomerDelete;
  let fixture: ComponentFixture<CustomerDelete>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CustomerDelete]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerDelete);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
