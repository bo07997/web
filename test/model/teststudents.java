package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class teststudents {

	@Test
	public void testSchemaExport(){
	       //�������ö���
			Configuration config =new Configuration().configure();
			//��������ע�����                                                                                                                                                                                                                           
			ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			//�����Ự��������
		SessionFactory	sessionFactory = config.buildSessionFactory(serviceRegistry);
			//�Ự����
		Session	session=sessionFactory.openSession();
			SchemaExport export=new SchemaExport(config);
			export.create(true, true);//(���ɱ�ṹ,��ӡsql���)
	}
}
