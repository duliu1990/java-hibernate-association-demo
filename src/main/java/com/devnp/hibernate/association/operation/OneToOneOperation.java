package com.devnp.hibernate.association.operation;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.devnp.hibernate.association.oto.model.Student;
import com.devnp.hibernate.association.oto.model.Transcripts;
import com.devnp.hibernate.util.HibernateProUtil;

/**
 * One-To-One demo test
 *
 * @author Du Liu
 */
public class OneToOneOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//save();
		
		//select();
		
		//update();
		
		//delete();
	}
	
	/**
	 * Create Student and Transcripts
	 */
	public static void save(){
		SessionFactory sessionFactory = HibernateProUtil.getSessionFactory() ;
		
		Session session = sessionFactory.openSession() ;
		
		session.beginTransaction();
		
		Student student = new Student() ;
		
		student.setName("XIAO LI");
		student.setAge(22);
		student.setBirthDate(new Date());
		
		Transcripts transcripts = new Transcripts();
		
		transcripts.setMathScores(99.22D);
		transcripts.setEnglishScores(89.00D);
		
		student.setTranscripts(transcripts);
		transcripts.setStudent(student);
		
		session.save(student);
		session.getTransaction().commit();
		
		HibernateProUtil.shutdown();
	}
	
	/**
	 * View Student and Transcripts
	 */
	public static void select(){
		SessionFactory sessionFactory = HibernateProUtil.getSessionFactory() ;
		
		Session session = sessionFactory.openSession() ;
		
		session.beginTransaction();
		
		Student student = (Student) session.get(Student.class, 2L);
		
		System.out.println(student);
		
		System.out.println("-------------------");
		
		System.out.println(student.getTranscripts());
		
		session.getTransaction().commit();
		
		HibernateProUtil.shutdown();
	}
	
	/**
	 * Update Student
	 */
	public static void update(){
		SessionFactory sessionFactory = HibernateProUtil.getSessionFactory() ;
		
		Session session = sessionFactory.openSession() ;
		
		session.beginTransaction();
		
		String hql = "from Student where sid=:sid" ; 
		
		Student student = (Student) session.createQuery(hql).setParameter("sid", 1L).uniqueResult();
		
		System.out.println(student);
		
		System.out.println("-------------------");
		
		System.out.println(student.getTranscripts());
		
		student.setName("XIAO WANG");
		
		student.getTranscripts().setEnglishScores(100D);
		
		session.update(student);
		
		session.getTransaction().commit();
		
		HibernateProUtil.shutdown();
	}
	
	/**
	 * Delete Student and Transcripts
	 */
	public static void delete(){
		SessionFactory sessionFactory = HibernateProUtil.getSessionFactory() ;
		
		Session session = sessionFactory.openSession() ;
		
		session.beginTransaction();
		
		String hql = "from Student where sid=:sid" ; 
		
		Student student = (Student) session.createQuery(hql).setParameter("sid", 1L).uniqueResult();
		
		session.delete(student);
		
		session.getTransaction().commit();
		
		HibernateProUtil.shutdown();
	}

}
