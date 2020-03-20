package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

	public School findByStudentId(Integer id);

	public Optional<School> findBySchoolCode(Integer schoolCode);

	

}
