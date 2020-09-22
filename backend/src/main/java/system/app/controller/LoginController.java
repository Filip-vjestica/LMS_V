package system.app.controller;

import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import system.app.model.RegistrovaniKorisnik;
import system.app.model.UserPermission;
import system.app.repository.PermissionRepository;
import system.app.repository.RegistrovaniKorisnikRepository;
import system.app.utils.TokenUtils;

import system.app.service.RegistrovaniKorisnikService;


@Controller
@RequestMapping("/api")
@CrossOrigin
public class LoginController {
	
	@Autowired
	RegistrovaniKorisnikService rs;
	

	@Autowired
	RegistrovaniKorisnikRepository ur;

	@Autowired
	PermissionRepository pr;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<HashMap<String, String>> login(@RequestBody RegistrovaniKorisnik user) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(),
					user.getPassword());
			
			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			UserDetails details = userDetailsService.loadUserByUsername(user.getUsername());
			String userToken = tokenUtils.generateToken(details);
			
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("token", userToken);
			
			return new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<HashMap<String, String>>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register(
	    @RequestBody RegistrovaniKorisnik regKorisnik) {

		regKorisnik.setPassword(passwordEncoder.encode(regKorisnik.getPassword()));

	this.rs.save(regKorisnik);
	regKorisnik.setUserPermissions(new HashSet<UserPermission>());


	this.rs.save(regKorisnik);

	return new ResponseEntity<String>(regKorisnik.getUsername(), HttpStatus.OK);
    }

}
