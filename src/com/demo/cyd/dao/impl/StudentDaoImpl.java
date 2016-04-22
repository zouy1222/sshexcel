package com.demo.cyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.demo.cyd.dao.StudentDao;
import com.demo.cyd.model.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public List<Student> findAll() {
		String hql="from Student s";
		List<Student> slist=hibernateTemplate.find(hql);
		return slist;
	}
	
	public Student findById(int id){
		return hibernateTemplate.get(Student.class, id);
	}
	
	public void add(List<Student> student){
		if(student.size() > 0){
			int sNum = student.size();
			for(int i=0;i<sNum;i++){
				hibernateTemplate.saveOrUpdate(student.get(i));
			}
		}
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
