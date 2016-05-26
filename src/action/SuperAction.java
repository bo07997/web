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
 *方便获得内置对象 
 */
public class SuperAction extends ActionSupport implements ServletContextAware,ServletRequestAware,ServletResponseAware{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//什么用？？？？？
	protected HttpServletResponse response;//响应对象
	protected HttpServletRequest request;//请求对象
	protected  ServletContext application;//全局对象
	protected  HttpSession session;//会话对象
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
