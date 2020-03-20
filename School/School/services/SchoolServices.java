package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;

import com.dto.StudentDTO;
import com.entities.School;
import com.exceptions.SchoolNotFoundException;
import com.exceptions.InvalidRequestException;
import com.repository.SchoolRepository;

@Service
public class Schoolervices {

	@Autowired
	private SchoolRepository schoolRepository;

	public School addSchool(SchoolDTO schoolDTO) throws InvalidRequestException {
		validateSchoolDTO(schoolDTO);
		Optional<School> schl = schoolRepository.findBySchoolCode(schoolDTO.getSchoolCode());
		if (schl.isPresent()) {
			throw new InvalidRequestException();
		}
		School school = convertDTOtoEntity(schoolDTO);
		schoolRepository.save(school);
		return school;
	}

	private void validateSchoolDTO(SchoolDTO schoolDTO) throws InvalidRequestException {

		if (ObjectUtils.isEmpty(schoolDTO.getName())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(schoolDTO.getSchoolCode())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(schoolDTO.getChancellor())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(schoolDTO.getAddress().getSteet1())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(schoolDTO.getAddress().getSteet2())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(schoolDTO.getAddress().getCity())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(schoolDTO.getAddress().getCountry())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(schoolDTO.getAddress().getPin())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(collegeDTO.getBachelor())) {
			throw new InvalidRequestException();
		}
	}

	public List<School> findAll() {
		return studentRepository.findAll();
	}

	public School getSchoolById(@PathVariable Integer id) throws SchoolNotFoundException {

		Optional<School> school = schoolRepository.findById(id);
		if (school.isPresent()) {
			return school.get();
		} else {
			throw new SchoolNotFoundException();
		}
	}

	public void deleteSchoolById(Integer id) throws Exception {

		Optional<School> school = schoolRepository.findById(id);
		if (school.isPresent()) {
			schoolRepository.deleteById(id);
		} else {
			throw new Exception("No School exist for given id");
		}
	}

	public School updateSchool(Integer id, SchoolDTO schoolDTO) throws Exception {

		Optional<School> school1 = schoolRepository.findById(id);
		if (!school1.isPresent()) {
			throw new SchoolNotFoundException();
		}
		validateSchoolDTO(schoolDTO);
		School school = convertDTOtoEntity(schoolDTO);
		school.setId(id);
		schoolRepository.save(school);
		return school;
	}

	public School convertDTOtoEntity(School DTO schoolDTO) throws InvalidRequestException {

		School school= new School();
		school.setCollegeCode(schoolDTO.getSchoolCode());
		schoolsetName(schoolDTO.getChancellor());
		school.setChancellor(schoolDTO.getChancellor());
		school.setAddress(schoolDTO.getAddress());
	
		return school;
	}
}
