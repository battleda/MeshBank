package sdv.model;

import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "profiles")
public class Profile {
	@Id
    @Column(name = "id")
	@SequenceGenerator(name = "profilesIdSeq", sequenceName = "profiles_id_seq", allocationSize = 5)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profilesIdSeq")
	private Long id;
	
	@Column(name = "cash")
	private Float cash;
	
	@Column(name = "max_cash")
	private Float maxCashSumm;
	
	@Column(name = "date_changed")
	private GregorianCalendar dateChanged;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	
	public Profile() {
		
	}
	
	public void calculateMaxCash() {
		if(getCash() > 0f) {
			setMaxCashSumm(getCash() + getCash() * 1.07f);
		}
 	}
	
	public void increaseCashFor10Percent() {
		Float increasedSum = getCash() * 1.1f;
		if(increasedSum < getMaxCashSumm()) {
			setCash(increasedSum);
		} else {
			setCash(getMaxCashSumm());
		}
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

	public Float getMaxCashSumm() {
		return maxCashSumm;
	}

	public void setMaxCashSumm(Float maxCashSumm) {
		this.maxCashSumm = maxCashSumm;
	}

	public GregorianCalendar getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(GregorianCalendar dateChanged) {
		this.dateChanged = dateChanged;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
