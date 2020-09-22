import { Adresa } from '../adresa/adresa';
import { FakultetInfo } from '../fakultet/fakultet';

export interface AdresaFakultet {
    id: number,
    adresa: Adresa,
    fakultet: FakultetInfo
}