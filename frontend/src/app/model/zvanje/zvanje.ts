import { NastavnikInfo } from '../nastavnik/nastavnik';
import { TipZvanjaInfo } from '../tip-zvanja/tip-zvanja';
import { NaucnaOblastInfo } from '../naucna-oblast/naucna-oblast';

export interface Zvanje {
    id: number,
    datumIzbora: Date,
    datumPrestanka: Date,
    tipZvanja: TipZvanjaInfo,
    naucnaOblast: NaucnaOblastInfo,
    nastavnici: NastavnikInfo[]
}

export interface ZvanjeInfo {
    id: number,
    tipZvanja: TipZvanjaInfo,
    naucnaOblast: NaucnaOblastInfo,
}