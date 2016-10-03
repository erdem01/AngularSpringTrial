package erdemc.deneme.persistence.dao.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import erdemc.deneme.model.Order;
import erdemc.deneme.persistence.dao.OrderDAO;

@Repository
public interface OrderDAOMongo extends OrderDAO, MongoRepository<Order, String> {
}
