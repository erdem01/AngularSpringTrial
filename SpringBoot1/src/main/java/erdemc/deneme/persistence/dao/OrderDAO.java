package erdemc.deneme.persistence.dao;

import java.util.List;

import erdemc.deneme.model.Order;

@FunctionalInterface
public interface OrderDAO {
	List<Order> findAll();
}
