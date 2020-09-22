import { StudentNaGodini } from '../student-na-godini/student-na-godini';
import { PohadjanjePredmeta } from '../pohadjanje-predmeta/pohadjanje-predmeta';
import { AdresaRegistrovaniKorisnik } from '../adresa-registrovani-korisnik/adresa-registrovani-korisnik';
import { UserPermission } from '../user-permission/user-permission';

export interface RegistrovaniKorisnik {
    id: number,
    username: string,
    password: string,
    ime: string,
    prezime: string,
    jmbg: string,
    email: string
    studentNaGodinama: StudentNaGodini[],
    pohadjanjePredmeta: PohadjanjePredmeta[],
    registrovaniKorisnikAdrese: AdresaRegistrovaniKorisnik[],
    roles: String;
}

export interface RegistrovaniKorisnikInfo {
    id: number,
    username: string,
    ime: string,
    prezime: String;
}

export interface RegistrovaniKorisnikInfo1 {
    id: number,
    username: string,
    password: string,
    roles: String;
}

