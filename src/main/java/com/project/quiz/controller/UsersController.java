package com.project.quiz.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.quiz.DTO.UserDTO;
import com.project.quiz.model.Users;
import com.project.quiz.service.UsersService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@PostMapping("/register")
	public Users registerUser(@RequestBody Users user) {
	    return usersService.saveUsers(user);
	}

    @GetMapping("/login/nameandpassword")
    public List<Users> searchByNameAndPassword(@RequestParam("username") String name,@RequestParam String password) {
        return usersService.getByNameAndPassword(name, password);
    }
    
    @PutMapping("/update")
    public Users updateUser(@RequestBody UserDTO usersDTO) {
        return usersService.update(usersDTO);
    }
	
}
