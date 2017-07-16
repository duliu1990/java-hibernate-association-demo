package com.devnp.hibernate.association.mtm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HERO_BOOK")
public class HeroBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "HERO_BOOK_ID")
	private Long heroBookId ;
	
	@Column(name = "HERO_BOOK_NAME")
	private String heroBookName ;
	
	@Column(name = "HERO_BOOK_PRICE")
	private Float heroBookPrice ;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="heroBooks")
	private Set<Hero> heros = new HashSet<Hero>();
	
	public HeroBook() {
		super();
	}
	
	public HeroBook(String heroBookName, Float heroBookPrice) {
		super();
		this.heroBookName = heroBookName;
		this.heroBookPrice = heroBookPrice;
	}

	public Long getHeroBookId() {
		return heroBookId;
	}

	public void setHeroBookId(Long heroBookId) {
		this.heroBookId = heroBookId;
	}

	public String getHeroBookName() {
		return heroBookName;
	}

	public void setHeroBookName(String heroBookName) {
		this.heroBookName = heroBookName;
	}

	public Float getHeroBookPrice() {
		return heroBookPrice;
	}

	public void setHeroBookPrice(Float heroBookPrice) {
		this.heroBookPrice = heroBookPrice;
	}

	public Set<Hero> getHeros() {
		return heros;
	}

	public void setHeros(Set<Hero> heros) {
		this.heros = heros;
	}

}
