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
	       //创建配置对象
			Configuration config =new Configuration().configure();
			//创建服务注册对象                                                                                                                                                                                                                           
			ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			//创建会话工厂对象
		SessionFactory	sessionFactory = config.buildSessionFactory(serviceRegistry);
			//会话对象
		Session	session=sessionFactory.openSession();
			SchemaExport export=new SchemaExport(config);
			export.create(true, true);//(生成表结构,打印sql语句)
	}
}
