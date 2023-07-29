package com.java.service;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.java.entity.MailInfo;

@Service
public interface MailerService {

	void send(MailInfo mail) throws MessagingException;

	void send(String to, String subject, String body) throws MessagingException;

	void queue(MailInfo mail);

	void queue(String to, String subject, String body);
}