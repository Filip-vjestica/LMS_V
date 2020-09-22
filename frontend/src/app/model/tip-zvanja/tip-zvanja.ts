import { ZvanjeInfo } from '../zvanje/zvanje';

export interface TipZvanja {
    id: number,
    naziv: string,
    zvanja: ZvanjeInfo[],
}

export interface TipZvanjaInfo {
    id: number,
    naziv: string,
}