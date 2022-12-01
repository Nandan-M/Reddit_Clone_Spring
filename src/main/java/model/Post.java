package model;

import javax.persistence.GenerationType;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	@NotEmpty(message = "Name Must be not Null")
	private String postName;
	@Lob
	@Nullable
	private String description;
	@Nullable
	private String url;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "userId" ,referencedColumnName = "userId" )
	private User user;
	private Instant createdDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Id" , referencedColumnName = "Id")
	private Subreddit subreddit;
}
