package com.InfoStudent.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.InfoStudent.entity.User;
import com.InfoStudent.repo.UserRepo;
import com.InfoStudent.service.UserService;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	private final UserRepo userRepo;

	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public User saveUser(User user) {
		
		User data=userRepo.save(user);
		
		return data;
		
	}
	

	@Override
	public List<User> findAllUser() {
		List<User> data =  this.userRepo.findAll();
		return data;
	}
	
	@Override
	public User updateUser(User user) {
		Optional<User> optional=userRepo.findById(user.getId());
		if(optional.isPresent()) {
			User dataUser=optional.get();
			dataUser.setName(user.getName());
			dataUser.setEmail(user.getEmail());
			dataUser.setPassword(user.getPassword());

			return userRepo.save(dataUser);
		}
		return null;
	}
@Override
public User  getById (Long id){
	Optional<User> list=userRepo.findById(id);
	try {
	
		
		return list.get();
	} catch (Exception e) {
		// TODO: handle exception
		log.info("error in fetching user by this id !", e.getMessage());
	}
return null;
}
@Override
public void deleteUser( Long id) {
        userRepo.deleteById(id);     

}
}
