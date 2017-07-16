package com.devnp.hibernate.association.oto.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Transcripts")
public class Transcripts implements Serializable{

	/**
	 * @author duliu
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "T_ID")
	private long transcriptsId ;
	
	@Column(name = "MATH_SCORES")
	private Double mathScores ;
	
	@Column(name = "ENGLISH_SCORES")
	private Double englishScores ;
	
	@Column(name = "CREATE_TIME")
    @CreationTimestamp
    private Date createTime;
	
	@OneToOne()
	@JoinColumn(name="S_ID")
	private Student student ;
	
	public Transcripts() {
		super();
	}

	public long getTranscriptsId() {
		return transcriptsId;
	}

	public void setTranscriptsId(long transcriptsId) {
		this.transcriptsId = transcriptsId;
	}

	public Double getMathScores() {
		return mathScores;
	}

	public void setMathScores(Double mathScores) {
		this.mathScores = mathScores;
	}

	public Double getEnglishScores() {
		return englishScores;
	}

	public void setEnglishScores(Double englishScores) {
		this.englishScores = englishScores;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Transcripts [transcriptsId=" + transcriptsId + ", mathScores="
				+ mathScores + ", englishScores=" + englishScores
				+ ", createTime=" + createTime + "]";
	}

}
