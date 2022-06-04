package sdv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sdv.dao.ProfileDao;
import sdv.dao.UserDao;
import sdv.model.Profile;
import sdv.model.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProfileDao profileDao;
	
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
	
	public void deleteUser(User user) {
		userDao.deleteById(user.getId());
	}
	
	public List<Profile> getAllProfiles() {
		return profileDao.findAll();
	}

	public void updateProfile(Profile profile) {
		profileDao.save(profile);
	}
	
	public User getUserById(Long id) {
		return userDao.getOne(id);
	}
	
}
