package model;
import java.time.Instant;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Token")
public class VerificationToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String token;
	
	@OneToOne(fetch = FetchType.LAZY)
	private User user;
	private Instant expiryDate;
	
}
