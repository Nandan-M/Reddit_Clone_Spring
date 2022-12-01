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
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String text;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "postId" ,referencedColumnName = "postId")
	private Post post;
	private Instant createdDate;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId" , referencedColumnName = "userId")
	private User user;
}
