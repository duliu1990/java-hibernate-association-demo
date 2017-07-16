package com.devnp.hibernate.util;

import java.util.EnumSet;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

public class HibernateXmlUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		
	    StandardServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().configure().build();
	    
	    Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().applyImplicitNamingStrategy(
	    		ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();  
	    
	    /*MetadataSources metadataSources = new MetadataSources(serviceRegistry);
	    
	    SchemaExport schemaExport = new SchemaExport();
	    
	    schemaExport.create(EnumSet.of(TargetType.DATABASE), metadataSources.buildMetadata());
	    
	    sessionFactory = metadataSources.buildMetadata().buildSessionFactory();*/
	    
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
