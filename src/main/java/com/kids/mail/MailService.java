package com.kids.mail;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * 
 * @author ortiz - lucianoortizsilva@gmail.com
 * @since 09/2017 http://netkiller.github.io/java/spring/boot/velocity.html
 */
@Service
@SuppressWarnings("deprecation")
public class MailService {

    private static final Logger LOGGER = Logger.getLogger(MailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;





    //TODO: REFATORAR, DEIXAR GENERICO PARA QUALQUER ORIGEM DE E-MAIL
    @Async
    public <T> void sendEmailToFamiliarVinculado(final String to, final String subject, final String message, boolean htmlMessage, final String nomeCrianca, final String nomeUsuario) {
	final MimeMessage mimeMsg = mailSender.createMimeMessage();
	final MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);
	try {
	    final Map<String, Object> model = new HashMap<String, Object>();
	    model.put("nomeCrianca", nomeCrianca);
	    model.put("nomeUsuario", nomeUsuario);

	    final String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "welcome.html", "UTF-8", model);
	    helper.setSubject("[KIDS] - ".concat(subject));
	    helper.setTo(to);
	    helper.setFrom("notreply@kids.com");
	    helper.setText(body, true);

	    mailSender.send(mimeMsg);

	    LOGGER.error("[KIDS] E-MAIL ENVIADO COM SUCESSO PARA : " + to);
	} catch (final Exception e) {
	    LOGGER.error("[KIDS] Ocoorreu um erro ao enviar email: ", e);
	}
    }

}