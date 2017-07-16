package com.devnp.hibernate.association.operation;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.devnp.hibernate.association.mtm.model.Hero;
import com.devnp.hibernate.association.mtm.model.HeroBook;
import com.devnp.hibernate.util.HibernateProUtil;

public class ManyToManyOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		save();
	}
	
	/**
	 * "Guo Jin" and "Huang Rou" belong "Eagle Shooting Heroes" book
	 * 
	 * "Yang Guo"  belong "Eagle Shooting Heroes" and "Shooting Knight" book
	 * 
	 */
	public static void save(){
		SessionFactory sessionFactory = HibernateProUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		session.getTransaction().begin();
		
		Hero hero1 = new Hero("Guo Jin", 33);
		Hero hero2 = new Hero("Huang Rou", 25);
		Hero hero3 = new Hero("Yang Guo", 22);
		
		HeroBook book1 = new HeroBook("Eagle Shooting Heroes", 22.3F);
		HeroBook book2 = new HeroBook("Shooting Knight", 23.5F);
		
		Set<HeroBook> heroBooks = new HashSet<HeroBook>();
		heroBooks.add(book1);
		
		hero1.setHeroBooks(heroBooks);
		hero2.setHeroBooks(heroBooks);
		
		hero3.getHeroBooks().add(book1);
		hero3.getHeroBooks().add(book2);
		
		session.save(hero1);
		session.save(hero2);
		session.save(hero3);
		
		session.getTransaction().commit();
		
		HibernateProUtil.shutdown();
	}
	
}
