import { Adresa } from '../adresa/adresa';
import { UniverzitetInfo } from '../univerzitet/univerzitet';

export interface AdresaUniverzitet {
    id: number,
    adresa: Adresa,
    univerzitet: UniverzitetInfo
}