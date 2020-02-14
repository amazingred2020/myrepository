package my.project.one.entity;

import java.io.Serializable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "actors")
public class Actor implements Serializable{

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
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "actors_films",
			joinColumns = @JoinColumn(name = "ACTOR_ID"),
			inverseJoinColumns = @JoinColumn(name = "FILM_ID"))
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
        return "Actor: id - "+ id +", firstName - " + firstName +", lastName - "+ lastName +", birth date - "+ 
        		dateformat.format(birthDate) +", country - "+ residenceCountry +", gender - " + gender;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((residenceCountry == null) ? 0 : residenceCountry.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Actor))
			return false;
		Actor other = (Actor) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (residenceCountry == null) {
			if (other.residenceCountry != null)
				return false;
		} else if (!residenceCountry.equals(other.residenceCountry))
			return false;
		return true;
	}
}
