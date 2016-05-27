package service;

import java.util.List;

import model.courses;
import model.students;

public interface CoursesDAO {
	
	// 全部选课
	public List<courses> queryALLCourses();

	// 单个学生选课
	public List<courses> queryCoursesBySid(String sid);

	// 删除学生选课
	public boolean delcourseBySid(Integer id);
	//添加选课资料
	public boolean addCourses(courses course);
	
	
}
