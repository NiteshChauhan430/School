package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.dto.StudentDTO;
import com.dto.SchoolDTO;
import com.entities.Student;
import com.entities.Student;
import com.exceptions.StudentNotFoundException;
import com.exceptions.SschoolNotFoundException;
import com.exceptions.InvalidRequestException;
import com.repository.StudentRepository;
import com.repository.SchoolRepository;

@Service
public class StudentServices {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SchoolRepository schoolRepository;

	public Student addStudent(StudentDTO studentDTO) throws InvalidRequestException {

		validatestudentDTO(studentDTO);
		Optional<Student> br = studentRepository.findStudentByAadhar(studentDTO.getAadhar());
		if (br.isPresent()) {
			throw new InvalidRequestException();
		}
		Student student = studentDtoToEntity(studentDTO);
		School school= schoolRepository.findByStudentId(student.getId());
		List<Student> list = new ArrayList<Student>();
		list.add(student);
		school.setStudent(list);
		schoolRepository.save(school);
		return student;
	}

	private void validatestudentDTO(StudentDTO studentDTO) throws InvalidRequestException {
		if (ObjectUtils.isEmpty(studentDTO.getName())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(studentbachelorDTO.getAadhar())) {
			throw new InvalidRequestException();
		}

	}

	public Student studentDtoToEntity(StudentDTO studentDTO) throws InvalidRequestException {

		Student student = new Student();
		student.setAadhar(studentDTO.getAadhar());
		student.setName(studentDTO.getName());
		student.setAddress(studentDTO.getAddress());

		return student;
	}

	public List<StudentDTO> studentEnityToDto(List<Student> student) throws InvalidRequestException {
		List<StudentDTO> studentList = new ArrayList<StudentDTO>();
		for (Student2: student) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setAadhar(student2.getAadhar());
			studentDTO.setName(student2.getName());
			studentDTO.setAddress(student2.getAddress());
			bachelorList.add(studentDTO);
		}
		return studentList;
	}

	public Student updateStudent(Integer id, StudentDTO studentDTO) throws Exception {

		Optional<Student> student1 = studentbachelorRepository.findById(id);
		if (!student1.isPresent()) {
			throw new StudentNotFoundException();
		}
		validatestudentDTO(studentDTO);
		Student student = studentbachekorDtoToEntity(bachelorDTO);
		student.setId(id);
		studentRepository.save(student);
		return student;

	}

	public Student getStudent(Integer id) throws StudentNotFoundException {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			return student.get();
		} else {
			throw new StudentBachelorNotFoundException();
		}
	}

	public void deleteStudentById(Integer id) throws StudentNotFoundException {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			studentRepository.deleteById(id);
		} else {
			throw new StudentNotFoundException();
		}
	}

	public List<Student> findAllStudent() {
		return studentRepository.findAll();
	}

	public void checkBachID(Integer id) throws Exception {

		Optional<Student> br1 = studentRepository.findById(id);
		if (!br1.isPresent()) {
			throw new StudentNotFoundException();
		}

	}

	public School getStudentSchool(Integer id) throws Exception {

		checkBachID(id);
		School school= schoolRepository.findBySchoolId(id);

		SchoolDTO schoolDTO = new SchoolDTO();
		StudentEnityToDto(school.getStudent());
		schoolDTO.setName(school.getName());
		schoolDTO.setSchoolCode(school.getSchoolCode());
		schoolDTO.setChancellor(school.getChancellor());
		schoolDTO.setAddress(school.getAddress());
		schoolDTO.setStudent(bachelorEnityToDto(school.getStudent()));
		return schoolDTO;

	}

	public void transferSchoolDTO(Integer b_id, Integer c_id, Integer r_id, School school) throws Exception {
		Optional<Student> student = studentRepository.findById(b_id); // check 1
		boolean studentFound = false;
		if (!student.isPresent()) {
			throw new StudentNotFoundException();
		}

		Optional<School> requiredSchool = schoolRepository.findById(r_id); // check 3
		if (!requiredSchool.isPresent()) {
			throw new schoolNotFoundException();
		}

		Optional<School> currentSchool = schoolRepository.findById(c_id);// check 2
		if (!currentSchool.isPresent()) {
			throw new SchoolNotFoundException();
		} else {

			for (Student studentList : currentschool.get().getStudent()) {
				if (studentList.getId() == b_id) {
					studentFound = true;
				}
				if (studentFound) {

					Optional<Student> b_new = studentbachelorRepository.findById(b_id);
					requiredSchool.get().getStudent().add(b_new.get());
					schoolcollegeRepository.save(requiredSchool.get());

					// delete
					// Optional<Student> b_new1 = studentRepository.findById(b_id);
					schoolRepository.deleteById(b_id);
					schoolRepository.save(currentSchool.get());
					break;
				}

			}
		}

	}
}
