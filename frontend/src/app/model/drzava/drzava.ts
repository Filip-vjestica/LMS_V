import { MestoInfo } from '../mesto/mesto';

export interface Drzava {
    id: number,
    naziv: string,
    mesta: MestoInfo[]
}

export interface DrzavaInfo {
    id: number,
    naziv: string,
}