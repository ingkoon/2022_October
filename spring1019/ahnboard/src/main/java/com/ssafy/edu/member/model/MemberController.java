package com.ssafy.edu.member.model;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.edu.board.model.GuestBook;
import com.ssafy.edu.board.model.GuestBookController;
import com.ssafy.edu.board.model.service.GuestService;
import com.ssafy.edu.member.model.mapper.MemberMapper;
import com.ssafy.edu.member.model.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(GuestBookController.class);
	
	@Autowired
	MemberService mservice;
	//Single Responsiblity Pricipal - 하나의 객체는 하나의 책임 -로직 -> 응집
	//LSP -> OCP -> IoC(DI를 개발자가 안함)
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, Member member, Model model) throws Exception {		
		logger.debug("Welcome  login {}.", member );			
		Member userinfo = mservice.login(member);
		if(userinfo != null) {
			session.setAttribute("userinfo", userinfo);
		}else {
			session.invalidate();
		}
//		model.addAttribute(userinfo);
		logger.debug(userinfo.getUserName());
		return "redirect:/guestlist";
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) throws Exception {
		logger.debug("Welcome  logout ." );	
		session.invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/registerMember", method = RequestMethod.GET)
	public String bfregist( Model model) throws Exception {		
		logger.debug("welcome bfregist");
		
		return "/regist";
	}	
	
	@RequestMapping(value = "/registerMember", method = RequestMethod.POST)
	public String registerMember( Member member, Model model) throws Exception {		
		logger.debug("welcome regist");		
		mservice.registerMember(member);
		
		
		return "redirect:/regist";
	}
}
