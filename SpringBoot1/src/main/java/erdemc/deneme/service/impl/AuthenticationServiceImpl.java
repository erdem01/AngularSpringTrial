package erdemc.deneme.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import erdemc.deneme.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private static final String USER_NAME = "root";
	
	private static final String HIDDEN = "root";

	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Override
	public UserDetails loadUserByUsername(String userCode) throws UsernameNotFoundException {
		if(!USER_NAME.equals(userCode)) {
			throw new UsernameNotFoundException("User with name '" + userCode + "' not found!");
		}
		final List<GrantedAuthority> userAuths = new ArrayList<>();
		userAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		userAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		final String encoded = passwordEncoder.encode(HIDDEN);
		return new org.springframework.security.core.userdetails.User(userCode, encoded, userAuths);
	}

}
