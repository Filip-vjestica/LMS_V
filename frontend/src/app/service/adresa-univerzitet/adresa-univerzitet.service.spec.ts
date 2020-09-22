import { TestBed } from '@angular/core/testing';

import { AdresaUniverzitetService } from './adresa-univerzitet.service';

describe('AdresaUniverzitetService', () => {
  let service: AdresaUniverzitetService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdresaUniverzitetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
