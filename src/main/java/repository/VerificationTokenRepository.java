package repository;

import model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long>{

}
