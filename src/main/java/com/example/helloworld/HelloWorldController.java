package com.example.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping("/")
	public String hello(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		System.out.println("Locale:" + locale);
		String greeting = messageSource.getMessage("greeting",null, locale);
		String change = messageSource.getMessage("lang.change",null, locale);
		String en = messageSource.getMessage("lang.en",null, locale);
		String fr = messageSource.getMessage("lang.fr",null, locale);
		String es = messageSource.getMessage("lang.es",null, locale);
		
		return greeting+ "\n" + change + "\n" + en + "\n" + fr +"\n" + es;
	}
	
}
