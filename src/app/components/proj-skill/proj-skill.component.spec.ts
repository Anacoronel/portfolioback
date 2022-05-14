import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjSkillComponent } from './proj-skill.component';

describe('ProjSkillComponent', () => {
  let component: ProjSkillComponent;
  let fixture: ComponentFixture<ProjSkillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjSkillComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjSkillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
