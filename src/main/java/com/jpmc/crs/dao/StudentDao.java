/**
 * 
 */
package com.jpmc.crs.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.jpmc.crs.model.Address;
import com.jpmc.crs.model.Student;

/**
 * @author Administrator
 *
 */
@Repository
public class StudentDao {

	Random random =  new Random();
	
	// Dummy database. Initialize with some dummy values.
	private static List<Student> students;
	{
		students = new ArrayList();
		students.add(new Student(101, "Smith", "sruss@gmail.com", new Address("10/11", "Bakers Street", 3495435L)));
		students.add(new Student(102, "Russ", "kwilliams@gmail.com", new Address("12/11", "Tendown Street", 248564723L)));
		students.add(new Student(103, "Kate", "Viral@gmail.com", new Address("15/11", "Bakers Street", 34524L)));
		students.add(new Student(104, "Jim", "jim@gmail.com", new Address("22/16", "Bakers Street", 432534L)));
	}

	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		student.setId(random.nextInt());
		students.add(student);
		return student;

	}

	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		for (Student c : students) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;

	}

	public Student deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		for (Student c : students) {
			if (c.getId().equals(id)) {
				students.remove(c);
				return c;
			}
		}
		return null;

	}

	public Student updateStudent(Student student,Integer id) {
		// TODO Auto-generated method stub
		for (Student c : students) {
			if (c.getId().equals(id)) {
				student.setId(c.getId());
				students.remove(c);
				students.add(student);
				return student;
			}
		}

		return null;
	}

	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return students;
	}

}
