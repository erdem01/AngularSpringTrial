package erdemc.deneme.persistence.dao;

import erdemc.deneme.model.User;

public interface UsersDAO {
	
	User findByUserCodeAndPassword(String userCode, String password);
	
	User findByUserCode(String userCode);
	
}
