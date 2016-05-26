package service.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import model.Users;
import model.students;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import db.MyhibernateSessionFactory;
import service.StudentsDAO;
import service.UsersDAO;

public class testserviceimpl {

	@Test
	public void test()
	
	{   
		String str="s00001";
		StudentsDAO sDao=new StudentsDAOimpl();
		students student=sDao.querystudentsBySid(str);
		System.out.println(student);
	}
}
