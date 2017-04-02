
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Chorbi extends Actor {

	// Constructors -----------------------------------------------------------
	public Chorbi() {
		super();
	}


	// Attributes -------------------------------------------------------------
	private String		picture;
	private String		description;
	private String		relationship;
	private Date		birthDate;
	private String		genre;
	private Coordinate	coordinate;
	private CreditCard	creditCard;
	private Boolean		ban;


	@NotBlank
	@URL
	public String getPicture() {
		return this.picture;
	}
	public void setPicture(final String picture) {
		this.picture = picture;
	}

	@NotBlank
	public String getDescription() {
		return this.description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}

	@NotBlank
	public String getRelationship() {
		return this.relationship;
	}
	public void setRelationship(final String relationship) {
		this.relationship = relationship;
	}

	@NotNull
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getBirthDate() {
		return this.birthDate;
	}
	public void setBirthDate(final Date birthDate) {
		this.birthDate = birthDate;
	}

	@NotBlank
	public String getGenre() {
		return this.genre;
	}
	public void setGenre(final String genre) {
		this.genre = genre;
	}

	@NotNull
	@Valid
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
	public void setCoordinate(final Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	@NotNull
	@Valid
	public CreditCard getCreditCard() {
		return this.creditCard;
	}
	public void setCreditCard(final CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	@NotNull
	public Boolean getBan() {
		return this.ban;
	}
	public void setBan(final Boolean ban) {
		this.ban = ban;
	}


	// Relationships ----------------------------------------------------------
	private Collection<Like>	giveLikes;
	private Collection<Like>	reciveLikes;
	private Collection<Chirp>	sentChirps;
	private Collection<Chirp>	reciveChirps;
	private SearchTemplate		searchTemplate;


	@OneToMany
	public Collection<Like> getGiveLikes() {
		return this.giveLikes;
	}
	public void setGiveLikes(final Collection<Like> giveLikes) {
		this.giveLikes = giveLikes;
	}

	@OneToMany
	public Collection<Like> getReciveLikes() {
		return this.reciveLikes;
	}
	public void setReciveLikes(final Collection<Like> reciveLikes) {
		this.reciveLikes = reciveLikes;
	}

	@OneToMany
	public Collection<Chirp> getSentChirps() {
		return this.sentChirps;
	}
	public void setSentChirps(final Collection<Chirp> sentChirps) {
		this.sentChirps = sentChirps;
	}

	@OneToMany
	public Collection<Chirp> getReciveChirps() {
		return this.reciveChirps;
	}
	public void setReciveChirps(final Collection<Chirp> reciveChirps) {
		this.reciveChirps = reciveChirps;
	}

	@OneToOne(optional = true)
	public SearchTemplate getSearchTemplate() {
		return this.searchTemplate;
	}
	public void setSearchTemplate(final SearchTemplate searchTemplate) {
		this.searchTemplate = searchTemplate;
	}

}
