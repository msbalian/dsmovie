package br.com.digitalemp.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digitalemp.dsmovie.dto.UserDto;
import br.com.digitalemp.dsmovie.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping
	public Page<UserDto> findAll(Pageable pageable) {
		return service.findAll(pageable);
	}

	@PutMapping
	public UserDto save(@RequestBody UserDto userDto) {
		return service.save(userDto);
	}
	
}
