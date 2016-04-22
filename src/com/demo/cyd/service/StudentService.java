package com.demo.cyd.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.demo.cyd.dao.StudentDao;
import com.demo.cyd.model.Student;

@Component("studentService")
public class StudentService {

	private StudentDao studentDao;

	public List<Student> findAll() {
		return studentDao.findAll();
	}
	
	public void add(List<Student> student){
		studentDao.add(student);
	}
	
	public Student findById(int id){
		return studentDao.findById(id);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	@Resource(name="studentDao")
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

}