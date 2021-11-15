package com.jpmc.crs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.crs.dao.StudentDao;
import com.jpmc.crs.model.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;

	public Student createStudent(Student student) {
		 studentDao.registerStudent(student);
		 return student;
	};
	
	public Student getStudentById(Integer id) {
		return studentDao.getStudentById(id);
	};
	
	public Student deleteStudent(Integer id) {
		return studentDao.deleteStudent(id);
	};
	
	public Student updateStudent(Student student, Integer id) {
		return studentDao.updateStudent(student,id);
	};
	
	public List<Student> getStudents() {
		return studentDao.getStudents();
	}
}
