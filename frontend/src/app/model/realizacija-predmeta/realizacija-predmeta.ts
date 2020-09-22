import { PohadjanjePredmeta } from '../pohadjanje-predmeta/pohadjanje-predmeta';
import { PredmetInfo } from '../predmet/predmet';

export interface RealizacijaPredmeta {
    id: number,
    predmet: PredmetInfo,
    pohadjanjaPredmeta: PohadjanjePredmeta[],
}

export interface RealizacijaPredmetaInfo {
    id: number,
    predmet: PredmetInfo,
}