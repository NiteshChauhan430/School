package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dto.StudentDTO;
import com.entities.Student;
import com.entities.School;
import com.services.StudentServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "StudentController")
@RestController
public class StudentController {

	@Autowired
	private StudentServices studentServices;

	@ApiOperation(value = "addStudent")
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody StudentDTO studentDTO) throws Exception {

		return ResponseEntity.ok(studentServices.addStudent(studentDTO));
	}

	@ApiOperation(value = "updateStudent")
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateBachelorStudent(@PathVariable Integer id, @RequestBody StudentDTO studentDTO)
			throws Exception {
		{
			studentServices.updateStudent(id, studentDTO);
			return new ResponseEntity<Student>(HttpStatus.OK);

		}
	}

	@ApiOperation(value = "findAllStudent")
	@GetMapping("/findAllStudent")
	public ResponseEntity<List<Student>> findAllStudent() {
		studentServices.findAllStudent();
		return ResponseEntity.ok(studentServices.findAllStudent());
	}

	@ApiOperation(value = "getStudent")
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") Integer id) throws Exception {
		Student student = studentServices.getStudent(id);
		return ResponseEntity.of(Optional.of(student));
	}

	@ApiOperation(value = "deleteStudentById")
	@DeleteMapping("/deleteStudentById/{id}")
	public String deleteStudentById(@PathVariable("id") Integer id) throws Exception {
		{
			studentServices.deleteStudentById(id);
			return "Student Successfully Deleted";
		}

	}

	@ApiOperation(value = "getStudentSchool")
	@GetMapping("/getStudentSchool/{id}")
	public ResponseEntity<Object> getStudentSchool(@PathVariable("id") Integer id) throws Exception {

		Object school= bachelorServices.getStudentSchool(id);
		return ResponseEntity.of(Optional.of(school));
	}

	@ApiOperation(value = "	transferStudent")
	@PutMapping("/transferStudent/{b_id}/{c_id}/{r_id}")
	public School transferStudentDTO(@PathVariable Integer b_id, @PathVariable Integer c_id,
			@PathVariable Integer r_id, @RequestBody School school throws Exception {

		bachelorServices.transferStudent(b_id, c_id, r_id, school 
		return school 
	}
}
