import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListBooksAdminComponent } from './list-books-admin.component';

describe('UserComponent', () => {
  let component: ListBooksAdminComponent;
  let fixture: ComponentFixture<ListBooksAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListBooksAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListBooksAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
