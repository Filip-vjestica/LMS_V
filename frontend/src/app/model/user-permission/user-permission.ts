import { RegistrovaniKorisnikInfo } from '../registrovani-korisnik/registrovani-korisnik';
import { PermissionInfo } from '../permission/permission';

export interface UserPermission {
    id: number,
    permission: PermissionInfo,
    registrovaniKorisnik: RegistrovaniKorisnikInfo,
}