package com.education.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.education.model.StudentClass;

@Repository
public interface ClsRepository extends JpaRepository<StudentClass,Integer> {

	
}