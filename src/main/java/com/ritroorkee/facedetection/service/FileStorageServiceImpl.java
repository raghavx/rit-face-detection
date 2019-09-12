package com.ritroorkee.facedetection.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ritroorkee.facedetection.model.FileDetails;
import com.ritroorkee.facedetection.repository.FileDetailsRepository;

@Service
public class FileStorageServiceImpl implements FileStorageService {

	@Autowired
	private FileDetailsRepository fileDetailsRepository;

	@Override
	public File save(MultipartFile file) {
		try {
			File temp = File.createTempFile("face", ".png");
			file.transferTo(temp);
			FileDetails fd = new FileDetails();
			fd.setName(file.getOriginalFilename());
			fd.setPath(temp.getAbsolutePath());
			fileDetailsRepository.save(fd);
			return temp;
		} catch (IOException e) {

		}
		return null;
	}

}
