package service;

import java.util.List;

import model.students;

//学生业务逻辑		
public interface StudentsDAO {
	
	//查询所有学生信息
	public List<students> queryALLstudents();
	
	//查询单个学生信息
	public students querystudentsBySid(String sid);
	
	//添加学生资料
	public boolean addStudents(students student);
	
	//修改学生资料
	public boolean updatestudent(students s);
	
	//删除学生资料
	public boolean delstudentBySid(String sid);
	

}
