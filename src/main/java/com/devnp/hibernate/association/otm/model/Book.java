package com.devnp.hibernate.association.otm.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "B_ID")
	private Long bId ;
	
	@Column(name = "B_NAME")
	private String bName ;
	
	@Column(name = "B_PRICE")
	private Double price ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "P_ID", nullable = false)
	private Person person ;
	
	public Book() {
		super();
	}
	
	public Book(String bName, Double price, Person person) {
		super();
		this.bName = bName;
		this.price = price;
		this.person = person ;
	}


	public Long getbId() {
		return bId;
	}

	public void setbId(Long bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Book [bId=" + bId + ", bName=" + bName + ", price=" + price
				+ "]";
	}
	
}
