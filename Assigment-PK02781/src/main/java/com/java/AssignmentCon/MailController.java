package com.java.AssignmentCon;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.MailerService;
import com.java.service.MailerServiceImpl;

@Controller
public class MailController {
	@Autowired
	MailerServiceImpl mailerServiceImpl;
	
	@RequestMapping("/sendMain")
	public String send(Model model, @Param("email") String email) throws MessagingException {
		String subject = "THANK YOU FOR SUBSCRIBED";
		String message = "Thank you for subscribing to our latest new";
		mailerServiceImpl.queue(email, subject, message);
		return "index";
	}
	
	@RequestMapping("/sendAbout")
	public String sendAbout(Model model, @Param("email") String email) throws MessagingException {
		String subject = "THANK YOU FOR SUBSCRIBED";
		String message = "Thank you for subscribing to our latest new";
		mailerServiceImpl.queue(email, subject, message);
		return "about";
	}

	@RequestMapping("/sendContact")
	public String contact(Model model, @Param("email") String email, @Param("subject") String subject
			, @Param("message") String message) throws MessagingException {
		mailerServiceImpl.queue(email, subject, message);
		return "about";
	}
}