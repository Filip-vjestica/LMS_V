import { UserPermission } from '../user-permission/user-permission';

export interface Permission {
    id: number,
    title: string,
    userPermissions: UserPermission[],
}

export interface PermissionInfo {
    id: number,
    title: string,
}