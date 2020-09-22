package system.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import system.app.model.RegistrovaniKorisnik;
import system.app.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserService() {
		super();
	}
	
	public Optional<RegistrovaniKorisnik> getUser(String username) {
		return userRepository.getByUsername(username);
	}
	
	public Optional<RegistrovaniKorisnik> getUser(String username, String password) {
		return userRepository.getByUsernameAndPassword(username, password);
	}

}
