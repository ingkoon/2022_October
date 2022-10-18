package com.ssafy.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.board.HomeController;
import com.ssafy.board.model.GuestBookDto;
import com.ssafy.board.model.service.GuestBookService;

@Controller
public class GuestBookController {
	
	
	@Autowired
	private GuestBookService gservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/guestlist", method = RequestMethod.GET)
	public String guestlist(Model model) throws Exception {
		logger.info("Welcome guestlist");		
		
		model.addAttribute("books", gservice.listArticle() );
		
		return "guestlist";
	}
	
	@RequestMapping(value = "/guestwrite", method = RequestMethod.GET)
	public String guestwrite(Model model) throws Exception {
		logger.info("Welcome guestlist");	
		
		return "guestwrite";
	}
	
	@RequestMapping(value = "/guestwrite", method = RequestMethod.POST)
	public String writeboard(GuestBookDto book, Model model) throws Exception {
		logger.info("Welcome guestwrite writeboard. {}", book);
		
		gservice.writeArticle(book); 
		
		return "redirect:/guestlist";
		//post는 forward를 자주 쓴다
	}
	
	@RequestMapping(value = "/guestdetail", method = RequestMethod.GET)
	public String guestDetail(int articleNo, Model model) throws Exception {
		logger.info("Welcome guestwrite writeboard");
		
//		gservice.writeArticle(articleNo); 
		model.addAttribute("book", gservice.detailArticle(articleNo));
		return "guestdetail";
		//post는 forward를 자주 쓴다
	}
}

