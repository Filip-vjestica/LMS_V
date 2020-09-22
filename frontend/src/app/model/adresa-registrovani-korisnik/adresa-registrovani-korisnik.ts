import { Adresa } from '../adresa/adresa';
import { RegistrovaniKorisnikInfo } from '../registrovani-korisnik/registrovani-korisnik';

export interface AdresaRegistrovaniKorisnik {
    id: number,
    adresa: Adresa,
    registrovaniKorisnik: RegistrovaniKorisnikInfo,
}