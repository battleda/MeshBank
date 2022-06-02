package sdv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sdv.dao.UserDao;
import sdv.model.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public void addUser(User user) {
		userDao.save(user);
	}
	
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	public boolean existsByEmail(String email) {
		return userDao.existsByEmail(email);
	}

	public List<User> getUsersByNameLike(String name) {
		return userDao.findByNameContains(name);
	}
	
}
