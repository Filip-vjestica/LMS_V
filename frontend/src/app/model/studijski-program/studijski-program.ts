import { FakultetInfo } from '../fakultet/fakultet';
import { GodinaStudije } from '../godina-studije/godina-studije';
import { NastavnikInfo } from '../nastavnik/nastavnik';

export interface StudijskiProgram {
    id: number,
    naziv: string,
    fakultet: FakultetInfo,
    godineStudija: GodinaStudije[],
    rukovodilac: NastavnikInfo,
}

export interface StudijskiProgramInfo {
    id: number,
    naziv: string,
    rukovodilac: NastavnikInfo,
}