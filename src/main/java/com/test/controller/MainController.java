package com.test.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.test.model.ContactForm;

@Controller
public class MainController {
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("/")
	public String viewHome(Model model) {
		model.addAttribute("contactForm", new ContactForm());
		return "index";
	}
	
	@RequestMapping("/{project}")
	public String viewProject(@PathVariable("project")String project) {
		if(project.equals("youtube")) return "project/youtube";
		return "error/500";
	}
	
	@PostMapping("/contact")
	public RedirectView sendContactForm(
			RedirectAttributes ra,
			@ModelAttribute("form")ContactForm form) {
		try {
			sendMail(form);
			ra.addFlashAttribute("mess", "Thank you for your concern!");
		} catch (Exception e) {
			ra.addFlashAttribute("mess", "Server got error, can't send your inquiry!");
		}
		return new RedirectView("/", true);
	}
	
	@SuppressWarnings("unused")
	private void sendMail(ContactForm contactForm) 
			throws UnsupportedEncodingException, MessagingException {
		
		MimeMessage mime = mailSender.createMimeMessage();
		MimeMessageHelper mimeHelper = new MimeMessageHelper(mime);
		
		mimeHelper.setFrom(contactForm.getEmail(), contactForm.getFullname());
		mimeHelper.setTo("thanhtre3651@gmail.com");
		
		String content = 
						"<p style='font-size: 16px; font-weight: bold;'>Fullname: " + contactForm.getFullname() + "</p>" +
						"<p style='font-size: 16px; font-weight: bold;'>Email: " + contactForm.getEmail() + "</p>" +
						"<p style='font-size: 16px; font-weight: bold;'>Phone: " + contactForm.getPhoneNumber() + "</p>" +
						"<p style='font-size: 16px; font-weight: bold;'>Mess: " + contactForm.getMessage() + "</p>"
						;
		
		mimeHelper.setSubject("You've just got a new contact form from " + contactForm.getEmail());
		mimeHelper.setText(content, true);
		
		mailSender.send(mime);
	}
}
