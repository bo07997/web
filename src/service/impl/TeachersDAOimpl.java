package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyhibernateSessionFactory;
import model.courses;
import model.teachers;
import service.TeachersDAO;

public class TeachersDAOimpl implements TeachersDAO {

	@Override
	public List<teachers> queryALLTeachers() {
		List<teachers> list=null;
		Transaction tx=null;
		
		String hql="";
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
			hql="from teachers"; 
		    Query query=session.createQuery(hql);
		    list=query.list();
//		    Query query = session.createQuery("from courses");
//		    List<courses> userList = query.list();
		    tx.commit();
//		    for(int i=0;i<list.size();i++){
//		    System.out.println(list.get(i));}/////////////////////²âÊÔ
		    return list;
		} 
		catch (Exception e) 
		{
		    	e.printStackTrace();
		    	return list;
			
		}
		finally
		{
			if(tx!=null)
			{
				tx=null;
			}
		}
		
	}

	@Override
	public boolean delTeacherByTid(Integer tid) {
		Transaction tx=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
		   teachers teacher=(teachers)session.get(teachers.class, tid);
		    session.delete(teacher);
		    tx.commit();
		    return true;
		   
		} catch (Exception e) 
		{
		    	e.printStackTrace();
		    	tx.commit();
		    	return false;
			
		}
		finally
		{
			if(tx!=null)
			{
				tx=null;
			}
		}
	}

	@Override
	public boolean addTeachers(teachers teacher) {
		Transaction tx=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
		    session.save(teacher);
		    tx.commit();
		    return true;
		    
		} catch (Exception e) 
		{
		    	e.printStackTrace();
                return false;			
		}
		finally
		{
			if(tx!=null)
			{
				tx=null;
			}
		}
	}

}
