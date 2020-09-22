import { NastavnikInfo } from '../nastavnik/nastavnik';
import { RealizacijaPredmetaInfo } from '../realizacija-predmeta/realizacija-predmeta';

export interface NastavnikNaRealizaciji {
    id: number,
    brojCasova: number,
    tipNastave: string,
    nastavnik: NastavnikInfo,
    realizacijaPredmeta: RealizacijaPredmetaInfo
}