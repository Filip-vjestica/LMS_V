package system.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import system.app.model.Permission;


@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long>{

}
