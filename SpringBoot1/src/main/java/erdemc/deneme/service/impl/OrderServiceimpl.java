package erdemc.deneme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Service;

import erdemc.deneme.model.Order;
import erdemc.deneme.persistence.dao.OrderDAO;
import erdemc.deneme.service.OrderService;

@Service
public class OrderServiceimpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;

	@PostFilter("filterObject.customer == 'erdem2'")
	@Override
	public List<Order> findAll() {
		return orderDAO.findAll();
	}

}
