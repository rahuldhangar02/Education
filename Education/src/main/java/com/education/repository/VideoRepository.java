package com.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.education.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video,Integer> {

}
