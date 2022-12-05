package service;
import config.SecurityConfig;
import model.VerificationToken;

import java.time.Instant;
import java.util.UUID;
import repository.VerificationTokenRepository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dto.RegisterRequest;
import lombok.AllArgsConstructor;
import model.User;
import repository.UserRepository;

@Service
@AllArgsConstructor
public class AuthService {
	

	private final PasswordEncoder passwordEncoder;
	
	private final UserRepository userRepository;
	
	private final VerificationTokenRepository verificationTokenRepository;
	
	@Transactional
	public void signup(RegisterRequest registerRequest) {
		User user = new User();
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setUserName(registerRequest.getUsername());
		user.setCreated(Instant.now());
		user.setEnabled(false);
		userRepository.save(user);
		
		String token = generateVerificationToken(user);
	}
	
	public String generateVerificationToken(User user) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setUser(user);
		verificationToken.setToken(token);
		
		verificationTokenRepository.save(verificationToken);
		
		return token;
		
	}

}
