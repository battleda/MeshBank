package sdv.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sdv.model.Profile;
import sdv.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
class _UserServiceTest {

	@Autowired 
	private UserService userService;
	
	@Test
	void logic() {
		User user = new User();
		user.setName("John Wik");
		user.setBithday(new Date());
		user.setEmail("someone@mail.com");
		
		Profile profile = new Profile();
		profile.setCash(100.0f);
		
		user.setProfile(profile);
		
		if(!userService.existsByEmail(user.getEmail())) {
			userService.addUser(user);
		}
				
		List<User> users = userService.getAllUsers();
		User testUser = users.get(0);
		assertTrue("Check user field name", user.getName().equals(testUser.getName()));
		
		users = userService.getUsersByNameLike("John");
		testUser = users.get(0);
		assertTrue("Check user field name", user.getName().equals(testUser.getName()));
		
	}

}
