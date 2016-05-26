package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyhibernateSessionFactory {
     private static SessionFactory sessionFactory;
     //˽�еĹ��췽������֤����ģʽ
     private MyhibernateSessionFactory()
     {
    	 
     }
     //���еľ�̬��������ûỰ��������
     public static SessionFactory getSessionFactory()
     {
    	 if(sessionFactory==null)
    	 {
    		 Configuration config =new Configuration().configure();
 			//��������ע�����                                                                                                                                                                                                                           
 			ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
 			//�����Ự��������
 		    SessionFactory	sessionFactory = config.buildSessionFactory(serviceRegistry);
    		 return sessionFactory;
    	 }
    	 else 
    	 {
    		  return sessionFactory;
    	 }
    	 
    	 
     }
	
	
	
}
