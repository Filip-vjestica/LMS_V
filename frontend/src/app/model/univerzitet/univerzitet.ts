import { AdresaUniverzitet } from '../adresa-univerzitet/adresa-univerzitet';
import { FakultetInfo } from '../fakultet/fakultet';
import { NastavnikInfo } from '../nastavnik/nastavnik';

export interface Univerzitet {
    id: number,
    naziv: string,
    datumOsnivanja: Date,
    univerzitetAdrese: AdresaUniverzitet[],
    fakulteti: FakultetInfo[],
    rektor: NastavnikInfo,
}

export interface UniverzitetInfo {
    id: number,
    naziv: string,
    rektor: NastavnikInfo,
}