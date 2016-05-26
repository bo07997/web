package action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import service.StudentsDAO;
import service.impl.StudentsDAOimpl;
import model.students;

public class StudentsAction extends SuperAction implements ModelDriven<students> {

	private students student=new students();//һ��Ҫ��ʼ��
	private static final long serialVersionUID = 7524786985348374469L;
	
	@Override
	public students getModel() {
		return this.student;
	}
	/*
	 * ��ʾȫ��ѧ��
	 */
	public String query()
	{
		StudentsDAO sDao=new StudentsDAOimpl();
		List<students> list=sDao.queryALLstudents();
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("students_list", list);
		}
		return "query_success";
		
	}

	/*
	 * ɾ��ѧ��,����ʾ
	 */
	public String delete ()
	{
		StudentsDAO sDao=new StudentsDAOimpl();
		String sid=request.getParameter("sid");
		sDao.delstudentBySid(sid);
		return "delete_success";
	}
	/*
	 * ���ѧ��,����ʾ
	 */
	public String add()
	{
		StudentsDAO sDao=new StudentsDAOimpl();
		sDao.addStudents(student);
		return "add_success";
	}

	/*
	 * ��ѯ����ѧ��������ʾ
	 */
	public String queryById()
	{
		StudentsDAO sDao=new StudentsDAOimpl();
		students student1=sDao.querystudentsBySid(student.getSid());
	
			session.setAttribute("students_one", student1);
		
		return "queryById_success";
	}
	/*
	 * ����ѧ����1����ʾ��ͼ
	 */
	public String modify()
	{
		String sid=request.getParameter("sid");
		StudentsDAO sDao=new StudentsDAOimpl();
		students stu=sDao.querystudentsBySid(sid);
		session.setAttribute("modify_students", stu);
		
		return "modify_success";
	}
	/*
	 * ����ѧ����2���������ݱ�
	 */
	public String save()
	{
		StudentsDAO sDao=new StudentsDAOimpl();
		sDao.updatestudent(student);
		return "save_success";
	}
}
