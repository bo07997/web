package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
/*
 *���������ö��� 
 */
public class SuperAction extends ActionSupport implements ServletContextAware,ServletRequestAware,ServletResponseAware{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//ʲô�ã���������
	protected HttpServletResponse response;//��Ӧ����
	protected HttpServletRequest request;//�������
	protected  ServletContext application;//ȫ�ֶ���
	protected  HttpSession session;//�Ự����
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		this.session=this.request.getSession();
	}

	@Override
	public void setServletContext(ServletContext application) {
		this.application=application;
	}

}
