package erdemc.deneme.controller;

import java.io.IOException;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;

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
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String displayLogin(@RequestPart("profilePicture") Part mFile) {
		try {
			mFile.write("/home/superdem/Downloads/a.jpg");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
}

