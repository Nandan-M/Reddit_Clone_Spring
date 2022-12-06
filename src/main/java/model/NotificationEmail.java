package model;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class NotificationEmail {

	private String subject;
	private String recipient;
	private String body;
}
