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

import com.dto.SchoolDTO;
import com.entities.School;
import com.services.SchoolServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "SchoolController")
@Controller
public class SchoolController {

	@Autowired
	private SchoolServices schoolServices;

	@ApiOperation(value = "addSchool")
	@PostMapping("/addSchool")
	public ResponseEntity<School> addSchool(@RequestBody SchoolDTO schoolDTO) throws Exception {

		return ResponseEntity.ok(schoolServices;.addSchool(schoolDTO));
	}

	@ApiOperation(value = "findAll")
	@GetMapping("/findAll")
	public ResponseEntity<List<School>> findAll() {
		schoolServices;.findAll();
		return ResponseEntity.ok(schoolServices;.findAll());
	}

	@ApiOperation(value = "getSchool")
	@GetMapping("/getSchool/{id}")
	public ResponseEntity<School> getSchoolById(@PathVariable("id") Integer id) throws Exception {
		School school= schoolServices.getschoolById(id);
		return ResponseEntity.of(Optional.of(school));
	}

	@ApiOperation(value = "deleteSchoolById")
	@DeleteMapping("/deleteSchoolById/{id}")
	public String deleteSchoolById(@PathVariable("id") Integer id) throws Exception {
		{
			schoolServices.deleteSchoolById(id);
			return "School Successfully Deleted";
		}
	}

	@ApiOperation(value = "updateSchool")
	@PutMapping("/updateSchool/{id}")
	public ResponseEntity<School> updateSchool(@PathVariable Integer id, @RequestBody SchoolDTO schoolDTO)
			throws Exception {
		{
			schoolServices.updateSchool(id, schoolDTO);
			return new ResponseEntity<School>(HttpStatus.OK);

		}
	}

}
