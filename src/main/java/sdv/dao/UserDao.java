package sdv.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sdv.model.User;

public interface UserDao extends JpaRepository<User, Long> {
	boolean existsByEmail(String email);
	User findByEmail(String email);
	List<User> findByNameContains(String name);
}
