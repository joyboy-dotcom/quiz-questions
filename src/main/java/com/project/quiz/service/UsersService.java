package com.project.quiz.service;

import java.util.List;

import com.project.quiz.DTO.UserDTO;
import com.project.quiz.model.Users;

public interface UsersService {
	List<Users> getByNameAndPassword(String name,String password);
	Users update(UserDTO users);
	Users saveUsers(Users users);
}
