package com.ritroorkee.facedetection.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

	File save(MultipartFile file);
}
