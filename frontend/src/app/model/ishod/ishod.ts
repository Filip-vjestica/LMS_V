import { PredmetInfo } from '../predmet/predmet';

export interface Ishod {
    id: number,
    datum: Date,
    naslov: string,
    opis: string,
    predmet: PredmetInfo,
}

export interface IshodInfo {
    id: number,
    datum: Date,
    naslov: string,
    opis: string,
    predmet: PredmetInfo,
}