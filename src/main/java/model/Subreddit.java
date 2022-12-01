package model;
import java.time.Instant;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


import lombok.*;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subreddit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@NotEmpty(message = "Name Must be not Null")
	private String Name;
	
	@NotEmpty(message = "Description Must be not Null")
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Post> post;
	
	private Instant createdDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	
	
	

}
