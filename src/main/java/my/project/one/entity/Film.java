package my.project.one.entity;

import java.io.Serializable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "films")
public class Film implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "NAME")
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "RELEASE")
	private Date releaseDate;
	
	@NotNull
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "DURATION_MINUTES", nullable = false)
	private int durationInMinutes;
	
	@Column(name = "MONEY_FEES", nullable = false)
	private long worldwideFees;
	
	@NotNull
	@Column(name = "GENRE")
	private String genre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCER_ID")
	private Producer producer;
	
	@ManyToMany(mappedBy = "films")
	private Set<Actor> actors = new HashSet<Actor>();
	
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

	public Date getReleasehDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date date) {
		this.releaseDate = date;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getDuration() {
		return this.durationInMinutes;
	}
	
	public void setDuration(int duration) {
		this.durationInMinutes = duration;
	}
	
	public long getMoneyFees() {
		return this.worldwideFees;
	}
	
	public void setMoneyFees(long fees) {
		this.worldwideFees = fees;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public Producer getProducer() {
		return producer;
	}
	
	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	
	public Set<Actor> getActors() {
		return actors;
	}
	
	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}
	
	@Override
    public String toString() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        return "Film: id - "+ id +", name - " + name +", release date - "+ dateformat.format(releaseDate) +", country - "+ 
        		country +", duration - "+ durationInMinutes +", money - $"+ worldwideFees +", genre - " + genre;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + durationInMinutes;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + (int) (worldwideFees ^ (worldwideFees >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Film))
			return false;
		Film other = (Film) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (durationInMinutes != other.durationInMinutes)
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (worldwideFees != other.worldwideFees)
			return false;
		return true;
	}
	
	
}
