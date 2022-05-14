import { TestBed } from '@angular/core/testing';

import { AboutLangService } from './about-lang.service';

describe('AboutLangService', () => {
  let service: AboutLangService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AboutLangService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
