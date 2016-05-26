package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyhibernateSessionFactory {
     private static SessionFactory sessionFactory;
     //私有的构造方法，保证单例模式
     private MyhibernateSessionFactory()
     {
    	 
     }
     //公有的静态方法，获得会话工厂对象
     public static SessionFactory getSessionFactory()
     {
    	 if(sessionFactory==null)
    	 {
    		 Configuration config =new Configuration().configure();
 			//创建服务注册对象                                                                                                                                                                                                                           
 			ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
 			//创建会话工厂对象
 		    SessionFactory	sessionFactory = config.buildSessionFactory(serviceRegistry);
    		 return sessionFactory;
    	 }
    	 else 
    	 {
    		  return sessionFactory;
    	 }
    	 
    	 
     }
	
	
	
}
