package br.com.digitalemp.dsmovie.dto;

import br.com.digitalemp.dsmovie.entities.User;

public class UserDto {

	private Long id;
	
	private String email;	

	public UserDto(Long id, String email) {
		this.id = id;
		this.email = email;
	}

	public UserDto(User user) {
		id = user.getId();
		email = user.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
