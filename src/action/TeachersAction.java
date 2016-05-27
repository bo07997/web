package action;

import java.util.List;

import service.CoursesDAO;
import service.TeachersDAO;
import service.impl.CoursesDAOimpl;
import service.impl.TeachersDAOimpl;
import model.Users;
import model.courses;
import model.students;
import model.teachers;

import com.opensymphony.xwork2.ModelDriven;

public class TeachersAction extends SuperAction implements ModelDriven<teachers> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 916513760511458243L;

	
	private teachers teacher=new teachers();//һ��Ҫ��ʼ��
	@Override
	public teachers getModel() {
		
		return this.teacher;
	}
	/*
	 * ��ѯ���н�ʦ��Ϣ
	 */
	public String query()
	{
		List<teachers> teacher=null;
		TeachersDAO tDao=new TeachersDAOimpl();
		try{
		students student=(students) session.getAttribute("loginStudent");
		Users user=(Users) session.getAttribute("loginUser");
		//System.out.println(user);
		//System.out.println(student);
		if(user.getTag().trim().equals("1"))
		{
			teacher=tDao.queryALLTeachers();
			session.setAttribute("teachers_list", teacher);
			return "query_success";
		}
		else
		{
			return "query_nosuccess";
		}
		}catch(Exception e){
			
		}
		return "query_nosuccess";
		
	}
	/*
	 * ɾ����ʦ��Ϣ,����ʾ
	 */
	public String delete ()
	{
		TeachersDAO tDao=new TeachersDAOimpl();
		//String sid=request.getParameter("id");////////////���
		Integer tid = Integer.valueOf(request.getParameter("tid"));
		tDao.delTeacherByTid(tid);
		return "delete_success";
	}
	
	/*
	 * ��ӽ�ʦ��Ϣ,����ʾ
	 */
	public String add()
	{
		TeachersDAO tDao=new TeachersDAOimpl();
		System.out.println(teacher);
		tDao.addTeachers(teacher);
		return "add_success";
	}
	/*
	 * ˢ��ҳ��
	 */
	public String f5()
	{
		
		return "f5_success";
	}
	
	
	
	
	

}
