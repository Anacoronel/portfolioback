import { TestBed } from '@angular/core/testing';

import { EducExpService } from './educ-exp.service';

describe('EducExpService', () => {
  let service: EducExpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EducExpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
