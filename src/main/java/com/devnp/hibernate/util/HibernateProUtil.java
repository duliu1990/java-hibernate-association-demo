package com.devnp.hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.devnp.hibernate.association.mtm.model.Hero;
import com.devnp.hibernate.association.mto.model.Company;
import com.devnp.hibernate.association.mto.model.Employee;
import com.devnp.hibernate.association.otm.model.Book;
import com.devnp.hibernate.association.otm.model.Person;
import com.devnp.hibernate.association.oto.model.Student;
import com.devnp.hibernate.association.oto.model.Transcripts;

public class HibernateProUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		Properties properties = new Properties();
	    properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect"); //数据库方言
	    properties.put("hibernate.show_sql", "true");	//是否打印SQL
	    properties.put("hibernate.hbm2ddl.auto","update"); //执行跟新，及如果表不存在则会自动创建表
	    
	    properties.put("hibernate.format_sql", "true"); //格式化
	    
	    properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
	    properties.put("hibernate.connection.password", "!qaz2wsx");
	    properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
	    properties.put("hibernate.connection.username", "root");

	    /*StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
	    standardServiceRegistryBuilder.applySettings(properties);

	    MetadataSources metadataSources = new MetadataSources(standardServiceRegistryBuilder.build());
	    metadataSources.addAnnotatedClass(Student.class);*/
	    
	    StandardServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(properties).build();
	    
	    MetadataSources metadataSources = new MetadataSources(serviceRegistry);
	    //add for one to one
	    metadataSources.addAnnotatedClass(Student.class).addAnnotatedClass(Transcripts.class);
	    
	    //add for one to many
	    metadataSources.addAnnotatedClass(Person.class).addAnnotatedClass(Book.class);
	    
	    //add for many to one
	    metadataSources.addAnnotatedClass(Employee.class).addAnnotatedClass(Company.class);
	    
	    //add for many to many
	    metadataSources.addAnnotatedClass(Hero.class).addAnnotatedClass(com.devnp.hibernate.association.mtm.model.HeroBook.class);
	    
	    Metadata metadata = metadataSources.getMetadataBuilder().applyImplicitNamingStrategy(
	    		ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();
	    
	    sessionFactory = metadata.getSessionFactoryBuilder().build();  
	    
	    return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
