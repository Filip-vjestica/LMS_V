import { GodinaStudijeInfo } from '../godina-studije/godina-studije';
import { RegistrovaniKorisnikInfo } from '../registrovani-korisnik/registrovani-korisnik';

export interface StudentNaGodini {
    id: number,
    godina: Date,
    indeks: string,
    godinaStudija: GodinaStudijeInfo,
    registrovaniKorisnik: RegistrovaniKorisnikInfo
}