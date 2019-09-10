package com.ritroorkee.facedetection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritroorkee.facedetection.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
