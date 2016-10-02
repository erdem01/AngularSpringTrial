package erdemc.deneme.persistence.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import erdemc.deneme.model.User;
import erdemc.deneme.persistence.dao.UsersDAO;

@Repository
@Transactional
public interface UsersDAOJPA extends UsersDAO, JpaRepository<User, Long> {

}
