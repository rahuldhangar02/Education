package com.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
