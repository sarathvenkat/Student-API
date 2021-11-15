/**
 * 
 */
package com.jpmc.crs.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpmc.crs.model.Student;
import com.jpmc.crs.utils.DBUtils;

/**
 * @author Administrator
 *
 */
@Repository
public class StudentDao {

	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		Student student = null;		
		Connection conn = DBUtils.getConnection();
		PreparedStatement stmnt = null;
		int studentId = 0;
		try {
				PreparedStatement stmntStud = conn.prepareStatement("select * from student where id=?");

				stmntStud.setInt(1, id);
			
				ResultSet rs = stmntStud.executeQuery();
				while (rs.next()) { 
				student =  new Student(rs.getInt(1), rs.getString(2), rs.getString(3), null);		
				}			
			} catch (SQLException ex) {
			throw new RuntimeException();
		}
		return student;
	}

	public Student deleteStudent(Integer id) {
		// TODO Auto-generated method stub	
		Student student = null;
		Connection conn = DBUtils.getConnection();
		PreparedStatement stmnt = null;
		int studentId = 0;
		try {
				PreparedStatement stmntStud = conn.prepareStatement("delete from student where id=?");

				stmntStud.setInt(1, id);
			
				int rows = stmntStud.executeUpdate();
				student = new Student(id, null, null, null);
			} catch (SQLException ex) {
			throw new RuntimeException();
		}
		return student;

	}

	public Student updateStudent(Student student,Integer id) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		PreparedStatement stmnt = null;
		int studentId = 0;
		try {
				PreparedStatement stmntStud = conn.prepareStatement("update student set ID=?, name=?, email=? where ID=?");

				stmntStud.setInt(1, student.getId());
				stmntStud.setString(2, student.getName());
				stmntStud.setString(3, student.getEmail());
				stmntStud.setInt(4, id);
			
				int i= stmntStud.executeUpdate();

			} catch (SQLException ex) {
			throw new RuntimeException(student.getName());
		}
		return student;
	}

	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		Student student = null;		
		List<Student> students = new ArrayList<Student>();
		Connection conn = DBUtils.getConnection();
		PreparedStatement stmnt = null;
		int studentId = 0;
		try {
				PreparedStatement stmntStud = conn.prepareStatement("select * from student");
			
				ResultSet rs = stmntStud.executeQuery();
				while(rs.next()) {
				student =  new Student(rs.getInt("ID"), rs.getString("name"), rs.getString("email"), null);	
				students.add(student);
				}
			} catch (SQLException ex) {
			throw new RuntimeException(student.getName());
		}
		return students;
	}
	
	public int registerStudent(Student student) {
		Connection conn = DBUtils.getConnection();
		PreparedStatement stmnt = null;
		int studentId = 0;
		try {
				PreparedStatement stmntStud = conn.prepareStatement("insert into student values(?,?,?)");

				stmntStud.setInt(1, student.getId());
				stmntStud.setString(2, student.getName());
				stmntStud.setString(3, student.getEmail());
			
				int i= stmntStud.executeUpdate();

			} catch (SQLException ex) {
			throw new RuntimeException(student.getName());
		}
		return studentId;
	}
}
