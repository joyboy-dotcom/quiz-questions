package com.project.quiz.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quiz.DTO.UserDTO;
import com.project.quiz.model.Users;
import com.project.quiz.repository.UsersRepository;

@Service
public class UsersServiceIMPL implements UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Users update(UserDTO usersDTO){
	    Users users = usersRepository.findByname(usersDTO.getName());
	    if (users!=null) {
	        users.setName(usersDTO.getName());
	        users.setEmail(usersDTO.getEmail());
	        users.setPassword(usersDTO.getPassword());

	        return usersRepository.save(users);
	    } else
			return null;
	}

	@Override
	public Users saveUsers(Users users) {
		return usersRepository.save(users);
	}

	@Override
	public List<Users> getByNameAndPassword(String name, String password) {
		return usersRepository.findByNameAndPassword(name, password);
	}

}
