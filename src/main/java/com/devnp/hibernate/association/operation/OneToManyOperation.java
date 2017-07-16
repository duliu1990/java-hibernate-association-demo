package com.devnp.hibernate.association.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.devnp.hibernate.association.otm.model.Book;
import com.devnp.hibernate.association.otm.model.Person;
import com.devnp.hibernate.util.HibernateProUtil;

/**
 * One-To-Many demo test
 *
 * @author Du Liu
 */
public class OneToManyOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 save();

		// select();

		// update();
		
		//delete();

	}

	/**
	 * Create Person and Book
	 */
	public static void save() {
		SessionFactory sessionFactory = HibernateProUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		session.getTransaction().begin();

		Person person = new Person("XIAO LI", 22);

		Book book1 = new Book("A brief history of mankind", 65.11D, person);
		Book book2 = new Book("Math", 25.11D, person);

		person.getBooks().add(book1);
		person.getBooks().add(book2);

		session.save(person);

		session.getTransaction().commit();

		HibernateProUtil.shutdown();
	}

	/**
	 * View Person and Book
	 */
	public static void select() {
		SessionFactory sessionFactory = HibernateProUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		session.getTransaction().begin();

		Person person = session.get(Person.class, 1L);

		System.out.println(person);

		System.out.println("------------------");

		System.out.println(person.getBooks());

		session.getTransaction().commit();

		HibernateProUtil.shutdown();
	}

	/**
	 * Update Book 
	 */
	public static void update() {
		SessionFactory sessionFactory = HibernateProUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		session.getTransaction().begin();

		Person person = session.get(Person.class, 1L);

		Book book = new Book("English", 35.11D, person);

		person.getBooks().add(book);

		session.update(person);

		session.getTransaction().commit();

		HibernateProUtil.shutdown();
	}

	/**
	 * Delete Person and Book
	 */
	public static void delete() {
		SessionFactory sessionFactory = HibernateProUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		session.getTransaction().begin();

		Person person = session.get(Person.class, 1L);

		session.delete(person);

		session.getTransaction().commit();

		HibernateProUtil.shutdown();
	}

}
