package com.kids.mail;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 
 * @author ortiz - lucianoortizsilva@gmail.com
 * @since 09/2017
 *
 */
@Service
public class MailService {

	private static final Logger LOGGER = Logger.getLogger(MailService.class);

	@Autowired
	private JavaMailSender mailSender;

	@SuppressWarnings("el-syntax")
	@Value("${mail.from:notreply@kids.com}")
	private String from;

	@Async
	public void send(final String to, final String subject, final String message, boolean htmlMessage) {
		final MimeMessage mimeMsg = mailSender.createMimeMessage();
		final MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);
		try {
			helper.setSubject("[KIDS] - ".concat(subject));
			helper.setText(message, htmlMessage);
			helper.setTo(to);
			helper.setFrom(from);
			mailSender.send(mimeMsg);
		} catch (final Exception e) {
			LOGGER.error("[KIDS] Ocoorreu um erro ao enviar email: ", e);
		}
	}

}