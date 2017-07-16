package com.devnp.hibernate.association.mtm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HERO")
public class Hero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "HERO_ID")
	private Long heroId ;
	
	@Column(name = "HERO_NAME")
	private String heroName ;
	
	@Column(name = "HERO_AGE")
	private Integer heroAge ;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "heroes_mapping", 
		joinColumns = {@JoinColumn(name = "HERO_ID", nullable = false, updatable = false)},
			inverseJoinColumns = { @JoinColumn(name = "HERO_BOOK_ID", nullable = false, updatable = false)})
	private Set<HeroBook> heroBooks = new HashSet<HeroBook>();
	

	public Hero() {
		super();
	}
	

	public Hero(String heroName, Integer heroAge) {
		super();
		this.heroName = heroName;
		this.heroAge = heroAge;
	}


	public Long getHeroId() {
		return heroId;
	}


	public void setHeroId(Long heroId) {
		this.heroId = heroId;
	}


	public String getHeroName() {
		return heroName;
	}


	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}


	public Integer getHeroAge() {
		return heroAge;
	}


	public void setHeroAge(Integer heroAge) {
		this.heroAge = heroAge;
	}


	public Set<HeroBook> getHeroBooks() {
		return heroBooks;
	}


	public void setHeroBooks(Set<HeroBook> heroBooks) {
		this.heroBooks = heroBooks;
	}

}
