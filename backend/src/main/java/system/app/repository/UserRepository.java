package system.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import system.app.model.RegistrovaniKorisnik;

public interface UserRepository extends CrudRepository<RegistrovaniKorisnik, Long>{
	Optional<RegistrovaniKorisnik> getByUsername(String username);
	Optional<RegistrovaniKorisnik> getByUsernameAndPassword(String username, String password);
}

