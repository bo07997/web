package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyhibernateSessionFactory;
import model.courses;
import model.students;
import service.CoursesDAO;

public class CoursesDAOimpl implements CoursesDAO {

	@Override
	public List<courses> queryALLCourses() {
		List<courses> list=null;
		Transaction tx=null;
		
		String hql="";
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
			hql="from courses"; 
		    Query query=session.createQuery(hql);
		    list=query.list();
//		    Query query = session.createQuery("from courses");
//		    List<courses> userList = query.list();
		    tx.commit();
//		    for(int i=0;i<list.size();i++){
//		    System.out.println(list.get(i));}/////////////////////测试
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
	public List<courses> queryCoursesBySid(String sid) {
		Transaction tx=null;
		String hql="";
		List<courses> course=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
			hql="from courses where SID=? "; 
		    Query query=session.createQuery(hql);
		    query.setParameter(0, sid);
             course=query.list();
		    tx.commit();
		    return course;
		    
		} catch (Exception e) 
		{
		    	e.printStackTrace();
		    	tx.commit();
			
		}
		finally
		{
			if(tx!=null)
			{
				tx=null;
			}
		}
		return course;
	}
	/*
	 * 通过sid删除学生
	 */
	@Override
	public boolean delcourseBySid(Integer id) {
		Transaction tx=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
		   courses course=(courses)session.get(courses.class, id);
		    session.delete(course);
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
/*
 * 添加选课信息
 */
	@Override
	public boolean addCourses(courses course) {
		
		Transaction tx=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
		    session.save(course);
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
