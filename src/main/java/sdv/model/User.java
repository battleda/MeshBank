package sdv.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
    @Column(name = "id")
	@SequenceGenerator(name = "usersIdSeq", sequenceName = "users_id_seq", allocationSize = 5)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersIdSeq")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "bithday")
	private Date bithday;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
	private Profile profile;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Phone> phones;
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBithday() {
		return bithday;
	}

	public void setBithday(Date bithday) {
		this.bithday = bithday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
}
