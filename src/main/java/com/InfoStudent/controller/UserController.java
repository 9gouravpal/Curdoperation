package com.InfoStudent.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InfoStudent.entity.User;
import com.InfoStudent.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<User>  saveUser(@RequestBody User user){
		User dataUser=userService.saveUser(user);
		return new ResponseEntity<>(dataUser,HttpStatus.CREATED);
	}
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		List<User> dataList =  this.userService.findAllUser();
		return new ResponseEntity<>(dataList,HttpStatus.ACCEPTED);
	}
	@PutMapping("update/{userId}")
	public User updateUser(@PathVariable Long userId, @RequestBody User user) {
		user.setId(userId);
		
		
		return userService.updateUser(user);
	}
@GetMapping("/single/{userId}")
public User getOneUser(@RequestParam Long userId) {
	User user=userService.getById(userId);
	return user;
}

@DeleteMapping("/deleteUser")
public String  deleteUser(@RequestParam("id") Long id) {
	userService.deleteUser(id);	
	return "User Deleted SuccessFully!" +id;
}
}
