package erdemc.deneme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import erdemc.deneme.service.OrderService;
import erdemc.deneme.service.UsersService;

@Controller
public class LoginController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String displayLogin() {
		System.out.println(usersService.findAll());
		System.out.println(orderService.findAll());
		return "login";
	}
	
}

