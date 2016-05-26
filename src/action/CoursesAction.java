package action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import model.Users;
import model.courses;
import model.students;
import service.CoursesDAO;
import service.StudentsDAO;
import service.UsersDAO;
import service.impl.CoursesDAOimpl;
import service.impl.StudentsDAOimpl;
import service.impl.UsersDAOimpl;

public class CoursesAction extends SuperAction implements ModelDriven<courses>{
	
	private courses course=new courses();//һ��Ҫ��ʼ��
	private static final long serialVersionUID = 1L;
	@Override
	public courses getModel() {
		this.course.setCtime(new Date());
		return this.course;
	}
	/*
	 * ��ѯ����ѡ����Ϣ
	 */
	public String query()
	{
		List<courses> course=null;
		CoursesDAO cDao=new CoursesDAOimpl();
		try{
		students student=(students) session.getAttribute("loginStudent");
		Users user=(Users) session.getAttribute("loginUser");
		//System.out.println(user);
		//System.out.println(student);
		if(user.getTag().trim().equals("1"))
		{
			course=cDao.queryALLCourses();
			session.setAttribute("courses_list", course);
		}
		else
		{
			course=cDao.queryCoursesBySid(user.getSid());
			session.setAttribute("courses_list", course);
		}
		}catch(Exception e){
			
		}
		return "query_success";
		
	}
	/*
	 * ɾ��ѧ��ѡ��,����ʾ
	 */
	public String delete ()
	{
		CoursesDAO sDao=new CoursesDAOimpl();
		//String sid=request.getParameter("id");////////////���
		Integer id = Integer.valueOf(request.getParameter("id"));
		sDao.delcourseBySid(id);
		return "delete_success";
	}
	
	/*
	 * ��ӿγ���Ϣ,����ʾ
	 */
	public String add()
	{
		CoursesDAO cDao=new CoursesDAOimpl();
		cDao.addCourses(course);
		System.out.println(course);
		return "add_success";
	}
}
