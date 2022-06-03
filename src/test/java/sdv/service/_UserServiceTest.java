package sdv.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sdv.model.Phone;
import sdv.model.Profile;
import sdv.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
class _UserServiceTest {

	@Autowired 
	private UserService userService;
	
	@Test
	void logic() {
		
		for(User user: User.generateUsers()) {
			userService.addUser(user);
		}
		
		ArrayList<User> users = (ArrayList<User>) userService.getAllUsers();
		
		assertEquals("Check for 5 added users", 5, users.size());
		
		for(User user: users) {
			userService.deleteUser(user);
		}
	}

}
