package com.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.model.UploadContent;
@Repository
public interface UploadContentRepository extends JpaRepository<UploadContent,Integer>{

}
