package my.project.one.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producers")
public class Producer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@NotNull
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	private Date birthDate;
	
	@Column(name = "COUNTRY")
	private String residenceCountry;
	
	@Column(name = "GENDER")
	private String gender;
	
	@OneToMany(mappedBy = "producer", 
			cascade = CascadeType.PERSIST,
			fetch = FetchType.LAZY)
	private Set<Film> films = new HashSet<Film>();

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date date) {
		this.birthDate = date;
	}

	public String getCountry() {
		return residenceCountry;
	}

	public void setCountry(String country) {
		this.residenceCountry = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Set<Film> getFilms() {
		return films;
	}
	
	public void setFilms(Set<Film> films) {
		this.films = films;
	}
	
	@Override
    public String toString() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        return "Producer: id - "+ id +",firstName - " + firstName +",lastName - "+ lastName +",birth date - "+ 
        		dateformat.format(birthDate) +",country - "+ residenceCountry +",gender - " + gender;
    }
}
