package service;

import java.util.List;

import model.students;

//ѧ��ҵ���߼�		
public interface StudentsDAO {
	
	//��ѯ����ѧ����Ϣ
	public List<students> queryALLstudents();
	
	//��ѯ����ѧ����Ϣ
	public students querystudentsBySid(String sid);
	
	//���ѧ������
	public boolean addStudents(students student);
	
	//�޸�ѧ������
	public boolean updatestudent(students s);
	
	//ɾ��ѧ������
	public boolean delstudentBySid(String sid);
	

}
