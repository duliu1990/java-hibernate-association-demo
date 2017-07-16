package com.devnp.hibernate.association.oto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Student")
public class Student implements Serializable{
	
	/**
	 * @author duliu
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "S_ID")
	private Long sid ;
	
	@Column(name = "NAME", nullable= false)
	private String name ;
	
	@Column(name = "AGE", nullable= false)
	private Integer age ;
	
	@Column(name = "BIRTH_DATE")
	@Temporal(TemporalType.DATE)
	private Date birthDate ;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="student", cascade = CascadeType.ALL)
	private Transcripts transcripts ;

	public Student() {
		super();
	}

	public Long getSid() {
		return sid;
	}


	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Transcripts getTranscripts() {
		return transcripts;
	}

	public void setTranscripts(Transcripts transcripts) {
		this.transcripts = transcripts;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", age=" + age
				+ ", birthDate=" + birthDate + "]";
	}

}
