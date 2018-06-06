package com.example.service;
import com.example.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	User findUserByEmail(String email);
	void saveUser(User user);
}
