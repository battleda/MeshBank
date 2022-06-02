package sdv.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
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
		User user = new User();
		user.setName("John Wik");
		user.setBithday(new Date());
		user.setEmail("someone@mail.com");
		
		Profile profile = new Profile();
		profile.setCash(100.0f);
		
		user.setProfile(profile);
		profile.setUser(user);
		
		Phone phone1 = new Phone();
		phone1.setValue("9147904393");
		phone1.setUser(user);
		
		Phone phone2 = new Phone();
		phone2.setValue("9147304395");
		phone2.setUser(user);
		
		ArrayList<Phone> phones = new ArrayList<>();
		phones.add(phone1);
		phones.add(phone2);
		
		user.setPhones(phones);
		
		if(!userService.existsByEmail(user.getEmail())) {
			userService.addUser(user);
		}
				
		List<User> users = userService.getAllUsers();
		User testUser = users.get(0);
		assertTrue("Check user field name", user.getName().equals(testUser.getName()));
		
		users = userService.getUsersByNameLike("John");
		testUser = users.get(0);
		assertTrue("Check user field name", user.getName().equals(testUser.getName()));
		
		assertNotNull("Is the profile is null", testUser.getProfile());
		
	}

}
