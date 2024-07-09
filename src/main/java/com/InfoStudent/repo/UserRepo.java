 package com.InfoStudent.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.InfoStudent.entity.User;

public interface UserRepo extends JpaRepository<User,Long> {

}
