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

import erdemc.deneme.model.User;
import erdemc.deneme.persistence.dao.UsersDAO;
import erdemc.deneme.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userCode) throws UsernameNotFoundException {
		final User user = usersDAO.findByUserCode(userCode);
		if(user == null) {
			throw new UsernameNotFoundException("User with name '" + userCode + "' not found!");
		}
		final List<GrantedAuthority> userAuths = new ArrayList<>();
		userAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		userAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		final String encoded = passwordEncoder.encode(user.getPassword());
		return new org.springframework.security.core.userdetails.User(user.getUserCode(), encoded, userAuths);
	}

}
