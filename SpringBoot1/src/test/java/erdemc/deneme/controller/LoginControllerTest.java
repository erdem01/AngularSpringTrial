package erdemc.deneme.controller;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.test.web.servlet.MockMvc;

import erdemc.deneme.service.OrderService;
import erdemc.deneme.service.UsersService;

public class LoginControllerTest {

	@Test
	public void testDisplayLogin() throws Exception {
		LoginController controller = new LoginController(mock(RabbitTemplate.class), mock(UsersService.class), mock(OrderService.class));
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/")).andExpect(view().name("login"));
	}
	
}
