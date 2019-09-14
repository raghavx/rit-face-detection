package com.ritroorkee.facedetection.service;

import java.io.File;
import java.io.IOException;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class FaceDetectionServiceImpl {
	static {
		nu.pattern.OpenCV.loadShared();
		// System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
	}
	
	@Autowired
	private ResourceLoader resourceLoader;

	public File detectFace(File fileOnServer, File fileOnServerWithFaceDetected) {
		System.out.println("\nRunning DetectFaceDemo");
		// Create a face detector from the cascade file in the resources
		// directory.
		CascadeClassifier faceDetector;
		try {
			faceDetector = new CascadeClassifier(
					resourceLoader
					.getResource("classpath:lbpcascade_frontalface.xml")
					.getFile().getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			faceDetector = null;
		}

		Mat image = Imgcodecs.imread(fileOnServer.getAbsolutePath());
		// Detect faces in the image.
		// MatOfRect is a special container class for Rect.
		MatOfRect faceDetections = new MatOfRect();
		faceDetector.detectMultiScale(image, faceDetections);
		System.out.println(String.format("Detected %s faces", 
				faceDetections.toArray().length));
		// Draw a bounding box around each face.
		for (Rect rect : faceDetections.toArray()) {
			Imgproc.rectangle(image, 
					new Point(rect.x, rect.y), 
					new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(255, 255, 255));
		}
		// Save the visualized detection.
		String filename = fileOnServerWithFaceDetected.getAbsolutePath();
		System.out.println(String.format("Writing %s", filename));
		Imgcodecs.imwrite(filename, image);
		return fileOnServerWithFaceDetected;
	}
}
