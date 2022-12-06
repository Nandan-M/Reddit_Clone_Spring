package service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.NotificationEmail;
import exceptions.RedditException;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {
	
	private final JavaMailSender mailSender;
	private final MailContentBuilder contentBuilder;
	

	public void sendMail(NotificationEmail notificationEmail) {
		
		MimeMessagePreparator messagePreparator = mimeMessage ->{
			MimeMessageHelper mimeHelper = new MimeMessageHelper(mimeMessage);
			mimeHelper.setFrom("Mungandla1@gmail.com");
			mimeHelper.setTo(notificationEmail.getRecipient());
			mimeHelper.setText(contentBuilder.build(notificationEmail.getBody()));
			mimeHelper.setSubject(notificationEmail.getSubject());
			};
		try {
			mailSender.send(messagePreparator);
			log.info("Activation Email sent");
			
		}
		catch(Exception e){
			throw new RedditException("Mail not sent due to error");
		}
	}
}
