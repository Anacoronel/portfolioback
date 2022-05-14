import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutLangComponent } from './about-lang.component';

describe('AboutLangComponent', () => {
  let component: AboutLangComponent;
  let fixture: ComponentFixture<AboutLangComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AboutLangComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AboutLangComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
