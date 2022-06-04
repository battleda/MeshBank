package sdv.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
	private GregorianCalendar bithday;
	
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

	public GregorianCalendar getBithday() {
		return bithday;
	}

	public void setBithday(GregorianCalendar bithday) {
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
	
	public static ArrayList<User> generateUsers() {
		ArrayList<User> result = new ArrayList<User>();
		
		User usr1 = new User();
		usr1.setName("John Swith");
		usr1.setEmail("smith145@mail.com");
		usr1.setBithday(new GregorianCalendar(2000, 0, 20));
		
		Profile profile1 = new Profile();
		profile1.setCash(100f);
		profile1.calculateMaxCash();
		profile1.setDateChanged(new GregorianCalendar());
		profile1.setUser(usr1);
		
		usr1.setProfile(profile1);
		
		ArrayList<Phone> phones1 = new ArrayList<Phone>();
		
		Phone usr1phone1 = new Phone();
		usr1phone1.setValue("9024335478");
		usr1phone1.setUser(usr1);
		
		phones1.add(usr1phone1);
		
		Phone usr1phone2 = new Phone();
		usr1phone2.setValue("9148885148");
		usr1phone2.setUser(usr1);
		
		phones1.add(usr1phone2);
		
		usr1.setPhones(phones1);
		
		result.add(usr1);
		
		User usr2 = new User();
		usr2.setName("Marry Steward");
		usr2.setEmail("misskiss@gmail.com");
		usr2.setBithday(new GregorianCalendar(1998, 3, 13));
		
		Profile profile2 = new Profile();
		profile2.setCash(1000f);
		profile2.calculateMaxCash();
		profile2.setDateChanged(new GregorianCalendar());
		profile2.setUser(usr2);
		
		usr2.setProfile(profile2);
		
		ArrayList<Phone> phones2 = new ArrayList<Phone>();
		
		Phone usr2phone1 = new Phone();
		usr2phone1.setValue("9884335426");
		usr2phone1.setUser(usr2);
		
		phones2.add(usr2phone1);
		
		Phone usr2phone2 = new Phone();
		usr2phone2.setValue("9142315458");
		usr2phone2.setUser(usr2);
		
		phones2.add(usr2phone2);
		
		Phone usr2phone3 = new Phone();
		usr2phone3.setValue("9026355477");
		usr2phone3.setUser(usr2);
		
		phones2.add(usr2phone3);
		
		usr2.setPhones(phones2);
		
		result.add(usr2);
		
		User usr3 = new User();
		usr3.setName("John Snow");
		usr3.setEmail("iknownothing@nomail.com");
		usr3.setBithday(new GregorianCalendar(1990, 7, 21));
		
		Profile profile3 = new Profile();
		profile3.setCash(1000f);
		profile3.calculateMaxCash();
		profile3.setDateChanged(new GregorianCalendar());
		profile3.setUser(usr3);
		
		usr3.setProfile(profile3);
		
		ArrayList<Phone> phones3 = new ArrayList<Phone>();
		
		Phone usr3phone1 = new Phone();
		usr3phone1.setValue("9534335444");
		usr3phone1.setUser(usr3);
				
		phones3.add(usr3phone1);
		
		usr3.setPhones(phones3);
		
		result.add(usr3);
		
		User usr4 = new User();
		usr4.setName("Gary Brother");
		usr4.setEmail("gbrother567@mail.com");
		usr4.setBithday(new GregorianCalendar(2001, 9, 20));
		
		Profile profile4 = new Profile();
		profile4.setCash(500f);
		profile4.calculateMaxCash();
		profile4.setDateChanged(new GregorianCalendar());
		profile4.setUser(usr4);
		
		usr4.setProfile(profile4);
		
		ArrayList<Phone> phones4 = new ArrayList<Phone>();
		
		Phone usr4phone1 = new Phone();
		usr4phone1.setValue("9993456934");
		usr4phone1.setUser(usr4);
		
		phones4.add(usr4phone1);
		
		Phone usr4phone2 = new Phone();
		usr4phone2.setValue("914678695");
		usr4phone2.setUser(usr4);
		
		phones4.add(usr4phone2);
		
		usr4.setPhones(phones4);
		
		result.add(usr4);
		
		User usr5 = new User();
		usr5.setName("Kate Snow");
		usr5.setEmail("snowshine@mail.com");
		usr5.setBithday(new GregorianCalendar(1996, 8, 13));
		
		Profile profile5 = new Profile();
		profile5.setCash(1200f);
		profile5.calculateMaxCash();
		profile5.setDateChanged(new GregorianCalendar());
		profile5.setUser(usr5);
		
		usr5.setProfile(profile5);
		
		ArrayList<Phone> phones5 = new ArrayList<Phone>();
		
		Phone usr5phone1 = new Phone();
		usr5phone1.setValue("9884336786");
		usr5phone1.setUser(usr5);
		
		phones5.add(usr5phone1);
		
		Phone usr5phone2 = new Phone();
		usr5phone2.setValue("9145555458");
		usr5phone2.setUser(usr5);
		
		phones5.add(usr5phone2);
		
		Phone usr5phone3 = new Phone();
		usr5phone3.setValue("9242452477");
		usr5phone3.setUser(usr5);
		
		phones5.add(usr5phone3);
		
		Phone usr5phone4 = new Phone();
		usr5phone4.setValue("9676665577");
		usr5phone4.setUser(usr5);
		
		phones5.add(usr5phone4);
		
		usr5.setPhones(phones5);
		
		result.add(usr5);
				
		return result;
	}
}
