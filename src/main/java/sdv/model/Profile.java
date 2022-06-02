package sdv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profile {
	@Id
    @Column(name = "id")
	@SequenceGenerator(name = "profilesIdSeq", sequenceName = "profiles_id_seq", allocationSize = 5)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profilesIdSeq")
	private Long id;
	
	private Float cash;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	public Profile() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getCash() {
		return cash;
	}

	public void setCash(Float cash) {
		this.cash = cash;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
