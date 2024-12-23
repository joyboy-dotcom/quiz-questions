package com.project.quiz.DTO;

public class UserDTO {
	private long id;
	private String name;
	private String email;
	private String password;
	
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(long id, String name,String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email=email;
		this.password = password;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UsersDTO [name=" + name + ", password="
				+ password +"]";
	}
	
	
}
