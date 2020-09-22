package system.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.app.model.RegistrovaniKorisnik;
import system.app.model.UserPermission;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserService userService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<RegistrovaniKorisnik> user = userService.getUser(username);
		
		if(user.isPresent()) {
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			for(UserPermission up : user.get().getUserPermissions()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(up.getPermission().getTitle()));
			}
			
			return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), grantedAuthorities);
		}
		
		return null;
	}

}
