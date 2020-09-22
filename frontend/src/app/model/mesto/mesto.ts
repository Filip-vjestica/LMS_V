import { Drzava, DrzavaInfo } from '../drzava/drzava';
import { Adresa } from '../adresa/adresa';

export interface Mesto {
    id: number,
    naziv: string,
    drzava: DrzavaInfo,
    adrese: Adresa[]
}

export interface MestoInfo {
    id: number,
    naziv: string,
}