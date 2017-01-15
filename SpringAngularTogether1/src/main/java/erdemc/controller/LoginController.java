package erdemc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import erdemc.model.User;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/protected/login", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody User findUser() {
		System.out.println("it's here");
		return new User();
	}

}
