import { TestBed } from '@angular/core/testing';

import { AdresaRegistrovaniKorisnikService } from './adresa-registrovani-korisnik.service';

describe('AdresaRegistrovaniKorisnikService', () => {
  let service: AdresaRegistrovaniKorisnikService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdresaRegistrovaniKorisnikService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
