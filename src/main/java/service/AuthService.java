package service;
import config.SecurityConfig;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dto.RegisterRequest;
import model.User;
import repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	
	public void signup(RegisterRequest registerRequest) {
		User user = new User();
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setUserName(registerRequest.getUsername());
		user.setCreated(Instant.now());
		user.setEnabled(false);
		userRepository.save(user);
	}

}
