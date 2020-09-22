import { TestBed } from '@angular/core/testing';

import { AdresaFakultetService } from './adresa-fakultet.service';

describe('AdresaFakultetService', () => {
  let service: AdresaFakultetService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdresaFakultetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
