package com.devnp.hibernate.association.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.devnp.hibernate.association.mto.model.Company;
import com.devnp.hibernate.association.mto.model.Employee;
import com.devnp.hibernate.util.HibernateProUtil;

/**
 * Many-To-One demo test
 *
 * @author Du Liu
 */
public class ManyToOneOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		save();
		//select();
		//update();
		
		//delete();
	}	
	
	/**
	 * Create new Company and Employee
	 */
	public static void save(){
		SessionFactory sessionFactory = HibernateProUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		session.getTransaction().begin();
		
		
		Company company = new Company("devnp.com");
		
		Employee employee1 = new Employee("JACK", 22);
		Employee employee2 = new Employee("Alen", 25);
		
		employee1.setCompany(company);
		employee2.setCompany(company);
		
		session.save(employee1);
		session.save(employee2);
		
		session.getTransaction().commit();
		
		HibernateProUtil.shutdown();
		
	}
	
	/**
	 * View Company from Employee
	 */
	public static void select(){
		SessionFactory sessionFactory = HibernateProUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		session.getTransaction().begin();
		
		Employee employee = session.get(Employee.class, 1L);
		
		System.out.println("Company ID : " + employee.getCompany().getcId() + " Name : " + employee.getCompany().getcName());
		
		session.getTransaction().commit();
		
		HibernateProUtil.shutdown();
	}
	
	/**
	 * Update the Company Name
	 */
	public static void update(){
		SessionFactory sessionFactory = HibernateProUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		session.getTransaction().begin();
		
		Employee employee = session.get(Employee.class, 1L);
		
		employee.getCompany().setcName("www.devnp.com");
		
		session.update(employee);
		
		session.getTransaction().commit();
		
		HibernateProUtil.shutdown();
	}
	
	/**
	 * Delete Employee
	 */
	public static void delete(){
		SessionFactory sessionFactory = HibernateProUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		session.getTransaction().begin();
		
		Employee employee = session.get(Employee.class, 1L);
		
		session.delete(employee);
		
		session.getTransaction().commit();
		
		HibernateProUtil.shutdown();
	}

}
