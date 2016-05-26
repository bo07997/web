package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyhibernateSessionFactory;
import model.students;
import service.StudentsDAO;
/*
 * ʵ��ѧ������ɾ�Ĳ�
 */
public class StudentsDAOimpl implements StudentsDAO {

	/*
	 * ����ȫ��ѧ��
	 */
	@Override
	public List<students> queryALLstudents() {
		List<students> list=null;
		Transaction tx=null;
		String hql="";
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
			hql="from students"; 
		    Query query=session.createQuery(hql);
		    list=query.list();
		    tx.commit();
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

	

	/*
	 * ���ѧ��
	 */
	@Override
	public boolean addStudents(students students) {
		students.setSid(getNewId());
		Transaction tx=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
		    session.save(students);
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

	@Override
	public boolean updatestudent(students s) {
		Transaction tx=null;
		String hql="";
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
	         session.update(s);
		    tx.commit();
		    return true;
		    
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
		return true;
	}

	/*
	 * ͨ��sidɾ��ѧ��
	 */
	@Override
	public boolean delstudentBySid(String sid) {
		Transaction tx=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
		    students students=(students)session.get(students.class, sid);//ͨ��ѧ��sid��ѯѧ��
		    session.delete(students);
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
	
	//����ѧ��ID
	private String getNewId()
	{
		Transaction tx=null;
		String hql="";
		String sid=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
			hql="select max(sid) from students  "; 
		    Query query=session.createQuery(hql);
             sid=(String) query.uniqueResult();
             if(sid==null||sid.equals(""))
             {
            	 //����Ĭ�ϱ��
            	 sid="s00001";
             }
             else {
            	 String temp=sid.substring(1);
            	 int i=Integer.parseInt(temp);
            	 i++;
            	 //�ٻ�ԭΪ�ַ���
            	 temp=String.valueOf(i);
            	 int len=temp.length();
            	 //�չ�5λ
            	 for(int j=0;j<5-len;j++)
            	 {
            		 temp="0"+temp;
            	 }
            	 sid="s"+temp;
			}
             
		    tx.commit();
		    return sid;
		    
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
		return sid;
	}

	
	/*
	 * ���ҵ���ѧ��
	 */
	@Override
	public students querystudentsBySid(String sid) {
		Transaction tx=null;
		String hql="";
		students students=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
		    tx=session.beginTransaction();
			hql="from students where SID=? "; 
		    Query query=session.createQuery(hql);
		    query.setParameter(0, sid);
             students=(model.students) query.uniqueResult();
		    tx.commit();
		    return students;
		    
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
		return students;
	}
	

}
