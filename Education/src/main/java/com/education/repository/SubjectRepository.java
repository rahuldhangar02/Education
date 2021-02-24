package com.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer>{

}
