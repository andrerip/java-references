package com.andrerip.spring.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MailConfiguration {
	
	@Autowired
	private MailProperties mailProperties;
	
	@Bean
	public void javaMailSender(){
		System.out.println(mailProperties.getHost());
	}

}
