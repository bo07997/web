package service;

import java.util.List;

import model.courses;
import model.teachers;

public interface TeachersDAO {
	
	   // ȫ����ʦ��Ϣ
		public List<teachers> queryALLTeachers();
		// ɾ����ʦ��Ϣ
		public boolean delTeacherByTid(Integer id);
		//��ӽ�ʦ��Ϣ
		public boolean addTeachers(teachers teacher);

}
