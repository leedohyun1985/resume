package com.doh.resume.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResumeController {

	private static final Logger logger = LoggerFactory.getLogger(ResumeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Locale locale, Model model) {
		logger.info("방문자발생=========================================================================");
		logger.info("request.getLocale() : " + request.getLocale());
		logger.info("request.getRequestURL() : " + request.getRequestURL());
		logger.info("request.getRemoteAddr() : " + request.getRemoteAddr());
		logger.info("request.getRemoteHost() : " + request.getRemoteHost());
		logger.info("request.getRemotePort() : " + request.getRemotePort());
		logger.info("request.getRemoteUser() : " + request.getRemoteUser());
		
		logger.info("접속 경로(referer) : " + request.getHeader("referer"));
		logger.info("유저의 시스템 정보(user-agent) : " + request.getHeader("user-agent"));
		logger.info("접속 ip(host) : " + request.getHeader("host"));
		logger.info("클라이언트 ip 주소(X-Forwarded-For) : " + request.getHeader("X-Forwarded-For"));
		logger.info("접속 경로(referer) : " + request.getHeader("referer")); 
		
		/*
		for (Enumeration<String> headerrNames = request.getHeaderNames(); headerrNames.hasMoreElements();) {
			try {
				logger.info(headerrNames.nextElement() + " : " + request.getHeader(headerrNames.nextElement()));	
			} catch (Exception e) {
				logger.info(headerrNames.nextElement() + " : 이 항목으로 인해 에러 발생");
			}
		}
		*/
		logger.info("================================================================================");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("lang", null == locale.getLanguage() ? "ko" : locale.getLanguage());
		model.addAttribute("country", null == locale.getCountry() ? "KR" : locale.getCountry());

		return "resume";
	}

}
