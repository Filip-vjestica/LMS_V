import { TestBed } from '@angular/core/testing';

import { GodinaStudijeService } from './godina-studije.service';

describe('GodinaStudijeService', () => {
  let service: GodinaStudijeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GodinaStudijeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
