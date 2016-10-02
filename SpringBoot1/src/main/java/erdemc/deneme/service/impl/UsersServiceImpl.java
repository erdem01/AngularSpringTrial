package erdemc.deneme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erdemc.deneme.model.User;
import erdemc.deneme.persistence.dao.jpa.UsersDAOJPA;
import erdemc.deneme.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDAOJPA usersDAO;
	
	@Override
	public List<User> findAll() {
		return usersDAO.findAll();
	}

}
