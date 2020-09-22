import { RegistrovaniKorisnikInfo } from '../registrovani-korisnik/registrovani-korisnik';
import { NastavnikNaRealizaciji } from '../nastavnik-na-realizaciji/nastavnik-na-realizaciji';
import { StudijskiProgram } from '../studijski-program/studijski-program';
import { FakultetInfo } from '../fakultet/fakultet';
import { ZvanjeInfo } from '../zvanje/zvanje';

export interface Nastavnik {
    id: number,
    biografija: string,
    zvanje: ZvanjeInfo,
    registrovaniKorisnik: RegistrovaniKorisnikInfo,
    nastavnikNaRealizacijama: NastavnikNaRealizaciji[],
    rukovodilacStudijskimProgramima: StudijskiProgram[],
    dekanNaFakultetima: FakultetInfo[],
}

export interface NastavnikInfo {
    id: number,
    biografija: string,
    zvanje: ZvanjeInfo,
    registrovaniKorisnik: RegistrovaniKorisnikInfo,
}