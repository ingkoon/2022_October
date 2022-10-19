package com.ssafy.edu.board.model;

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

import com.ssafy.edu.HomeController;
import com.ssafy.edu.board.model.service.GuestService;


@Controller
public class GuestBookController {
	
	private static final Logger logger = LoggerFactory.getLogger(GuestBookController.class);
	
	@Autowired
	GuestService gservice;
	//Single Responsiblity Pricipal - 하나의 객체는 하나의 책임 -로직 -> 응집
	//LSP -> OCP -> IoC(DI를 개발자가 안함)
	
	
	@RequestMapping(value = "/guestlist", method = RequestMethod.GET)
	public String guestlist( Model model) throws Exception {
		logger.debug("Welcome  guestlist ." );
	
		model.addAttribute("books", gservice.listArticle() );
		
		return "board/guestlist";
	}
	
	@RequestMapping(value = "/guestwrite", method = RequestMethod.GET)
	public String bfguestwrite( Model model) throws Exception {
		logger.debug("Welcome  bfguestwrite ." );			
		
		return "board/guestwrite";
	}
	
	@RequestMapping(value = "/guestwrite", method = RequestMethod.POST)
	public String guestwrite(GuestBook book, Model model) throws Exception {
		logger.debug("Welcome  guestwrite {}.", book );					
		gservice.writeArticle(book);
		return "redirect:/guestlist";
	}
	
	@RequestMapping(value = "/guestdetail", method = RequestMethod.GET)
	public String guestdetail(int articleNo, Model model) throws Exception {
		logger.debug("Welcome  guestdetail ." );
	
		model.addAttribute("book", gservice.detailArticle(articleNo));
		
		return "board/guestdetail";
	}
	
}