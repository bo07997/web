package service;

import model.Users;
import model.students;

//ҵ���߼��ӿ�
public interface UsersDAO {

	
	//�û���¼����
	public boolean userslogin(Users user);
	
	//ͨ��user��Ϣ����student��Ϣ
	//public students queryStudents(Users user);
	//ͨ����¼��Ϣ����user�����Ϣ
	public Users queryUsers(String username);
	
}
