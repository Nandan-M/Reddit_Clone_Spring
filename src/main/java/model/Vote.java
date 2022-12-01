package model;
import java.time.Instant;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long voteId;
	private VoteType voteType;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "postId", referencedColumnName = "postId")
	private Post post;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId" ,referencedColumnName = "userId" )
	private User user;
	
}
