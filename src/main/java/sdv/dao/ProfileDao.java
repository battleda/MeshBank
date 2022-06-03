package sdv.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sdv.model.Profile;

public interface ProfileDao extends JpaRepository<Profile, Long> {
	
}
