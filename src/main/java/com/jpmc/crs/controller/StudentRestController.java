/**
 * 
 */
package com.jpmc.crs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.crs.model.Student;
import com.jpmc.crs.service.StudentService;
import com.jpms.crs.exception.StudentNotFound;

/**
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
public class StudentRestController {

	
	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public List getstudents() {

		return studentService.getStudents();
	}

	@GetMapping("/students/{id}")
	public ResponseEntity getstudent(@PathVariable("id") Integer id) {

		Student student = studentService.getStudentById(id);
		if (student == null) {
			throw new StudentNotFound("No student found for ID " + id);
			//return new ResponseEntity("No student found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(student, HttpStatus.OK);
	}

	@PostMapping(value = "/post/students")
	public ResponseEntity createstudent(@RequestBody Student student) {

		Student studentSaved = studentService.createStudent(student);

		return new ResponseEntity(studentSaved, HttpStatus.OK);
	}

	@DeleteMapping("/delete/students/{id}")
	public ResponseEntity deletestudent(@PathVariable Integer id) {

		if (null == studentService.deleteStudent(id)) {
			return new ResponseEntity("No student found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/put/students/{id}")
	public ResponseEntity updatestudent(@PathVariable Integer id, @RequestBody Student student) {

		student = studentService.updateStudent(student, id);

		if (null == student) {
			return new ResponseEntity("No student found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(student, HttpStatus.OK);
	}
}
