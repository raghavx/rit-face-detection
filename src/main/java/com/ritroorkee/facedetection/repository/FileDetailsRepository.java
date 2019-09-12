package com.ritroorkee.facedetection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritroorkee.facedetection.model.FileDetails;

public interface FileDetailsRepository 
extends JpaRepository<FileDetails, String>{

}
