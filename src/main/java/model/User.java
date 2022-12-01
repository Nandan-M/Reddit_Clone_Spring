package model;

import java.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	
	@NotEmpty(message = "User name must be not null")
	private String userName;
	
	@NotEmpty(message = "Password must be not empty")
	private String password;
	
	
	@Email
	@NotEmpty(message = "Email is required")
	private String email;
	
	private Instant created;
	private boolean enabled;

}
