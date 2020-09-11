import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchconnectionsComponent } from './searchconnections.component';

describe('SearchconnectionsComponent', () => {
  let component: SearchconnectionsComponent;
  let fixture: ComponentFixture<SearchconnectionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchconnectionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchconnectionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
