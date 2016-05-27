package service;

import java.util.List;

import model.courses;
import model.teachers;

public interface TeachersDAO {
	
	   // 全部教师信息
		public List<teachers> queryALLTeachers();
		// 删除教师信息
		public boolean delTeacherByTid(Integer id);
		//添加教师信息
		public boolean addTeachers(teachers teacher);

}
