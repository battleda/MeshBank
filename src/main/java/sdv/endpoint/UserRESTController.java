package sdv.endpoint;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sdv.model.User;
import sdv.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserRESTController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(
            value = "/api/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<User>> getAllUsers() {
		Collection<User> result = userService.getAllUsers();
		return new ResponseEntity<Collection<User>>(result, HttpStatus.OK);
	}

}
