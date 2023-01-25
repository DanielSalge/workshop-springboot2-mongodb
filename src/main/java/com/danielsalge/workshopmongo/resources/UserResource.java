package com.danielsalge.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import com.danielsalge.workshopmongo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielsalge.workshopmongo.domain.User;
import com.danielsalge.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(UserDTO::new).toList();
		return ResponseEntity.ok().body(list);
	}
}
