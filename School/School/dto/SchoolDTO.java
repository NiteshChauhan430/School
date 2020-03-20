package com.dto;

import java.util.List;

import com.entities.Address;

public class SchoolDTO {

	private Integer schoolCode;

	private String name;

	private String chancellor;

	private Address address;

	
	  private List<StudentDTO> student
	 


	public List<StudentDTO> getStudent() {
		return student;
	}

	public void setStudent(List<StudentDTO> student{
		this.student = student;
	}

	public Integer getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(Integer schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChancellor() {
		return chancellor;
	}

	public void setChancellor(String chancellor) {
		this.chancellor = chancellor;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SchoolDTO [schoolCode=" + schoolCode + ", name=" + name + ", chancellor=" + chancellor + ", address="
				+ address + ", student=" + student + "]";
	}

	

}
