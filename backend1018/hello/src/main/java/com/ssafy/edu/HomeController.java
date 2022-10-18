package com.ssafy.edu;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		// model에 담는 것이 request scope이다.
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("name", "안승태" );		
		return "home";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome list");
		
		ArrayList<String> lists = new ArrayList<String>();
		lists.add("안승태");
		lists.add("이인재");
		lists.add("강은진");
		lists.add("류한민");
		lists.add("장한결");
		model.addAttribute("lists",  lists);
		return "list";
	}
	
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public String home2(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		// request scope
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	
}
