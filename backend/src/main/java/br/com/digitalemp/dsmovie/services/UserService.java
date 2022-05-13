package br.com.digitalemp.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.digitalemp.dsmovie.dto.UserDto;
import br.com.digitalemp.dsmovie.entities.User;
import br.com.digitalemp.dsmovie.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public Page<UserDto> findAll(Pageable pageable) {
		
		Page<User> page = repository.findAll(pageable);
		
		return page.map(user -> new UserDto(user));
		
	}
	
	
	@Transactional	
	public UserDto save(UserDto dto) {
		
		User user = repository.findByEmail(dto.getEmail());
		if (user == null) {
			// did not find. Must save it
			User newUser = new User();
			newUser.setEmail(dto.getEmail());
			repository.saveAndFlush(newUser);
			return new UserDto(newUser);
		} else {
			return new UserDto(user);
		}
		
	}
	
}
