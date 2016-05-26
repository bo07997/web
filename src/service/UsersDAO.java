package service;

import model.Users;
import model.students;

//业务逻辑接口
public interface UsersDAO {

	
	//用户登录方法
	public boolean userslogin(Users user);
	
	//通过user信息查找student信息
	//public students queryStudents(Users user);
	//通过登录信息查找user表的信息
	public Users queryUsers(String username);
	
}
