package sdv.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sdv.model.Phone;
import sdv.model.User;

public interface PhoneDao extends JpaRepository<Phone, Long> {
	User findByValue(String value);
}
