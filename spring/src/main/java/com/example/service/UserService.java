package com.example.service;
import com.example.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
	User findUserByEmail(String email);
	void saveUser(User user);
}
