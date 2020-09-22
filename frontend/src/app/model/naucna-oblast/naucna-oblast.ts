import { ZvanjeInfo } from '../zvanje/zvanje';

export interface NaucnaOblast {
    id: number,
    naziv: string,
    zvanja: ZvanjeInfo[]
}

export interface NaucnaOblastInfo {
    id: number,
    naziv: string,
}