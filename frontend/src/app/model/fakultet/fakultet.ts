import { UniverzitetInfo } from '../univerzitet/univerzitet';
import { NastavnikInfo } from '../nastavnik/nastavnik';
import { AdresaFakultet } from '../adresa-fakultet/adresa-fakultet';
import { StudijskiProgramInfo } from '../studijski-program/studijski-program';

export interface Fakultet {
    id: number,
    naziv: string,
    univerzitet: UniverzitetInfo,
    dekan: NastavnikInfo,
    fakultetAdrese: AdresaFakultet[],
    studijskiProgrami: StudijskiProgramInfo[]
}

export interface FakultetInfo {
    id: number,
    naziv: string,
    univerzitet: UniverzitetInfo,
    dekan: NastavnikInfo,
}

export interface FakultetInfo1 {
    id: number,
    naziv: string,
    
}