package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.StudentsDAO;
import service.UsersDAO;
import service.impl.StudentsDAOimpl;
import service.impl.UsersDAOimpl;
import model.Users;
import model.students;

import com.opensymphony.xwork2.ModelDriven;

public class UsersAction extends SuperAction //SuperAction����web���ö��󣬿���ֱ��ʹ��
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user=new Users();
    

	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public String login()
	{
		UsersDAO uDao=new UsersDAOimpl();
       StudentsDAO sDao=new StudentsDAOimpl();
       Users user1=null;
      try{
    	  
		if(uDao.userslogin(user))
		{   //����ȥ��������������������
			user1=uDao.queryUsers(user.getUsername());
			session.setAttribute("loginUser", user1);
			students student=sDao.querystudentsBySid(user1.getSid());
			session.setAttribute("loginStudent", student);
			session.setAttribute("loginStudentname", student.getSname());
			return "login_success";
		}
          else{
        	  this.addFieldError("inputError", "�û��������������");
        	  return "login_false";		
        	  }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "login_false";
	}
	@SkipValidation
	public String logout()
	{
		if(session.getAttribute("loginUsername")!=null)
		{
			session.removeAttribute("loginUsername");
		}
		
		return "logout_success";
		
	}





	@Override
	public void validate() {
		try {
			if(user.getUsername().trim().equals(""))
			{
				this.addFieldError("UsernameError", "�û�������Ϊ��");
			}
			if(user.getPassword().length()<6)
			{
			    this.addFieldError("PasswordError", "���벻������6λ");	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	

}
