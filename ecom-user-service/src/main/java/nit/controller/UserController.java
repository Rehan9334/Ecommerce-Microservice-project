package nit.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nit.entity.User;
import nit.repository.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {
  
	private final UserRepository repo;

	public UserController(UserRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public List<User> getAllUsers() {
		return repo.findAll();
	}
	
	@PostMapping
	public User create(@RequestBody User user) {
		return repo.save(user);
	}
	
}
