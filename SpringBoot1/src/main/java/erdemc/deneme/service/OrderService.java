package erdemc.deneme.service;

import java.util.List;

import erdemc.deneme.model.Order;

@FunctionalInterface
public interface OrderService {
	List<Order> findAll();
}
