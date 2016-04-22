package com.demo.cyd.dao;

import java.util.List;

import com.demo.cyd.model.Student;

public interface StudentDao {
	public List<Student> findAll();
	public Student findById(int id);
	public void add(List<Student> student);

}
