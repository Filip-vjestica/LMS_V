import { RealizacijaPredmeta } from '../realizacija-predmeta/realizacija-predmeta';
import { RegistrovaniKorisnikInfo } from '../registrovani-korisnik/registrovani-korisnik';

export interface PohadjanjePredmeta {
    id: number,
    konacnaOcena: number,
    realizacijaPredmeta: RealizacijaPredmeta,
    registrovaniKorisnik: RegistrovaniKorisnikInfo,
}