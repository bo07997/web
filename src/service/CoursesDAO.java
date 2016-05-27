package service;

import java.util.List;

import model.courses;
import model.students;

public interface CoursesDAO {
	
	// ȫ��ѡ��
	public List<courses> queryALLCourses();

	// ����ѧ��ѡ��
	public List<courses> queryCoursesBySid(String sid);

	// ɾ��ѧ��ѡ��
	public boolean delcourseBySid(Integer id);
	//���ѡ������
	public boolean addCourses(courses course);
	
	
}
