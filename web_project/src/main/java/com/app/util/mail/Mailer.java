package com.app.util.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rajdeep siddhapura.
 */
public class Mailer
{
	private static final Logger LOGGER = LoggerFactory.getLogger(Mailer.class);

	public static void sendMailViaGmail(String fromAddr, String toAddr, String toName, String subject, String body)
	{
		// Sender's email ID needs to be mentioned
		final String username = "email@gmail.com";//change accordingly
		final String password = "password";//change accordingly

		// Assuming you are sending email through smtp.gmail.com
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(fromAddr));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toAddr));

			// Set Subject: header field
			message.setSubject(subject);

			// Now set the actual message
			message.setText(body);

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			LOGGER.error("Exception while sending Mail - " + e);
		}
	}
}
