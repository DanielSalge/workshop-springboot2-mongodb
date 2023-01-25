package com.danielsalge.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import com.danielsalge.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsalge.workshopmongo.domain.User;
import com.danielsalge.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
