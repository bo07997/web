package service.impl;

import java.util.List;







import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyhibernateSessionFactory;
import model.Users;
import model.students;
import service.UsersDAO;
//实现登录业务接口，返回boolen值
public class UsersDAOimpl implements UsersDAO {

	@Override
	public boolean userslogin(Users user) {
                
		
		Transaction tx=null;
		String hql="";
	try {
		
		Session session=MyhibernateSessionFactory.getSessionFactory().
				getCurrentSession();
		tx=session.beginTransaction();
		//Users为model中的类，而不是数据库中的表
		hql="from Users where USERNAME=? and PASSWORD=? ";
		
		Query query=session.createQuery(hql);
	
		query.setParameter(0, user.getUsername());
		query.setParameter(1, user.getPassword());
		List list =query.list();
		tx.commit();//提交事务
		if(list.size()>0)
		{
			return true;
		}
		else return false;
	    } 
	catch (Exception e) 
	{
	e.printStackTrace();
	return false;
    }
	finally
	{
		if(tx!=null)
		{
			//tx.commit();
			tx=null;
		}
		
	}

		
		
	}

//	@Override
//	public students queryStudents(Users user) {
//		Transaction tx=null;
//		String hql="";
//		students student=null;
//	try {
//		
//		Session session=MyhibernateSessionFactory.getSessionFactory().
//				getCurrentSession();
//		tx=session.beginTransaction();
//		//Users为model中的类，而不是数据库中的表
//		hql="from students where SID=? ";
//		
//		Query query=session.createQuery(hql);
//	
//		query.setParameter(0, user.getSid());
//		student =(students) query.uniqueResult();
//		tx.commit();//提交事务
//		return student;
//		}
//	catch (Exception e) 
//	{
//	e.printStackTrace();
//	
//    }
//	finally
//	{
//		if(tx!=null)
//		{
//			//tx.commit();
//			tx=null;
//		}
//		
//	}
//return student;
//	}

	
	
	
	@Override
	public Users queryUsers(String username) {
		Transaction tx=null;
		String hql="";
		Users user=null;
	try {
		
		Session session=MyhibernateSessionFactory.getSessionFactory().
				getCurrentSession();
		tx=session.beginTransaction();
		//Users为model中的类，而不是数据库中的表
		hql="from Users where USERNAME=? ";
		
		Query query=session.createQuery(hql);
	
		query.setParameter(0, username);
		user =(Users) query.uniqueResult();
		tx.commit();//提交事务
		return user;
		}
	catch (Exception e) 
	{
	e.printStackTrace();
	
    }
	finally
	{
		if(tx!=null)
		{
			//tx.commit();
			tx=null;
		}
		
	}
return user;
	}

	

}
