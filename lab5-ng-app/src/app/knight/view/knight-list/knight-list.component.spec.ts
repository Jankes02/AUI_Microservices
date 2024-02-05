import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KnightListComponent } from './knight-list.component';

describe('KnightListComponent', () => {
  let component: KnightListComponent;
  let fixture: ComponentFixture<KnightListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [KnightListComponent]
    });
    fixture = TestBed.createComponent(KnightListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
