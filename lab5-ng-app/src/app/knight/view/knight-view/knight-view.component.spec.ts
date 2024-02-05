import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KnightViewComponent } from './knight-view.component';

describe('KnightViewComponent', () => {
  let component: KnightViewComponent;
  let fixture: ComponentFixture<KnightViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [KnightViewComponent]
    });
    fixture = TestBed.createComponent(KnightViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
