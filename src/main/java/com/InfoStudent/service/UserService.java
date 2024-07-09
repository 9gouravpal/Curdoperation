package com.InfoStudent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.InfoStudent.entity.User;



@Service
public interface UserService {

	User saveUser(User user);

	List <User> findAllUser();

	User updateUser(User user);

	User  getById(Long id);
	
	void  deleteUser(Long id);
	

}
