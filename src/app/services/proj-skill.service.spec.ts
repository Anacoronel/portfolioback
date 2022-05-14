import { TestBed } from '@angular/core/testing';

import { ProjSkillService } from './proj-skill.service';

describe('ProjSkillService', () => {
  let service: ProjSkillService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProjSkillService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
