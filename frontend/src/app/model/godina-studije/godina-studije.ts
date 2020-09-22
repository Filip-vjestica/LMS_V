import { StudentNaGodini } from '../student-na-godini/student-na-godini';
import { PredmetInfo } from '../predmet/predmet';
import { StudijskiProgramInfo } from '../studijski-program/studijski-program';

export interface GodinaStudije {
    id: number,
    naziv: string,
    studijskiProgram: StudijskiProgramInfo,
    studentiNaGodini: StudentNaGodini[],
    predmeti: PredmetInfo[]
}

export interface GodinaStudijeInfo {
    id: number,
    naziv: string,
    studijskiProgram: StudijskiProgramInfo,
}
