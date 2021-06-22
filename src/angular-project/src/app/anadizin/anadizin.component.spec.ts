import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnadizinComponent } from './anadizin.component';

describe('AnadizinComponent', () => {
  let component: AnadizinComponent;
  let fixture: ComponentFixture<AnadizinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnadizinComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnadizinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
