package dto;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Entity

public class RegisterRequest {

	private String email;
	private String password;
	private String username;
}
