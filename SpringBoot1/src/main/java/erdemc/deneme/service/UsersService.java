package erdemc.deneme.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import erdemc.deneme.model.User;

@FunctionalInterface
public interface UsersService {

	@Cacheable("usersCache")
	List<User> findAll();
	
}
