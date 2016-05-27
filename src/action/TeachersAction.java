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

	
	private teachers teacher=new teachers();//一定要初始化
	@Override
	public teachers getModel() {
		
		return this.teacher;
	}
	/*
	 * 查询所有教师信息
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
	 * 删除教师信息,并显示
	 */
	public String delete ()
	{
		TeachersDAO tDao=new TeachersDAOimpl();
		//String sid=request.getParameter("id");////////////深究！
		Integer tid = Integer.valueOf(request.getParameter("tid"));
		tDao.delTeacherByTid(tid);
		return "delete_success";
	}
	
	/*
	 * 添加教师信息,并显示
	 */
	public String add()
	{
		TeachersDAO tDao=new TeachersDAOimpl();
		System.out.println(teacher);
		tDao.addTeachers(teacher);
		return "add_success";
	}
	/*
	 * 刷新页面
	 */
	public String f5()
	{
		
		return "f5_success";
	}
	
	
	
	
	

}
