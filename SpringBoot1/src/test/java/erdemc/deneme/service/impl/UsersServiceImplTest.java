package erdemc.deneme.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import erdemc.deneme.model.User;
import erdemc.deneme.persistence.dao.jpa.UsersDAOJPA;
import erdemc.deneme.service.impl.UsersServiceImplTest.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class)
public class UsersServiceImplTest {
	
	@Autowired
	private UsersDAOJPA usersDAOJPA;
	
	@Autowired
	private UsersServiceImpl usersService;

	@Test
	public void testFindUser() {
		final String userCode = "userCode";
		final User mockUser = mock(User.class);
		doReturn(mockUser).when(usersDAOJPA).findByUserCode(userCode);
		assertEquals(mockUser, usersService.findUser(userCode));
	}
	
	@Configuration
	public static class TestConfig {
		
		@Bean
		public UsersDAOJPA usersDAO() {
			return mock(UsersDAOJPA.class);
		}
		
		@Bean
		public UsersServiceImpl usersService() {
			return new UsersServiceImpl();
		}
		
	}

}
