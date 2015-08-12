package com.app.util.audit;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.util.mail.Mailer;

/**
 * Created by rajdeep siddhapura.
 */
public class AuditPublisher extends AppenderBase<ILoggingEvent>
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AuditPublisher.class);

	private static final String toName = "App Audit Mail";
	private static final String toAddress = "abc@gmail.com";
	private static final String fromAddress = "xyz@gmail.com";
	private static final String subject = "App Audit";

	@Override
	protected void append(final ILoggingEvent eventObject)
	{
		new Thread(new Runnable()
		{
			public void run()
			{
				sendMailViaGmail(eventObject);
			}
		}).start();
	}

	private static void sendMailViaGmail(ILoggingEvent eventObject)
	{
		Long userId = -1l;
		String body = "UserID : " + userId + "\n"
			+ "Thread : " + eventObject.getThreadName() + "\n"
			+ "Level  : " + eventObject.getLevel() + "\n"
			+ "Time   : " + new SimpleDateFormat("MM/dd/yyyy '-' HH:mm:ss").format(eventObject.getTimeStamp()) + "\n"
			+ eventObject.getFormattedMessage() + "\n";

		Mailer.sendMailViaGmail(fromAddress, toAddress, toName, subject, body);
	}
}
