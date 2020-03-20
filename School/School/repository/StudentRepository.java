package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Optional<Student> findStudentByAadhar(Long aadhar);
	public Optional<Student> findByAadhar(Long aadhar);

}
