package com.example.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping("/")
	public String hello() {
		System.out.println("Locale:" + LocaleContextHolder.getLocale());
		String greeting = messageSource.getMessage("greeting",null, LocaleContextHolder.getLocale());
		String change = messageSource.getMessage("lang.change",null,LocaleContextHolder.getLocale());
		String en = messageSource.getMessage("lang.en",null, LocaleContextHolder.getLocale());
		String fr = messageSource.getMessage("lang.fr",null, LocaleContextHolder.getLocale());
		String es = messageSource.getMessage("lang.es",null, LocaleContextHolder.getLocale());
		
		return greeting+ "\n" + change + "\n" + en + "\n" + fr +"\n" + es;
	}
	
}
