package com.ssafy.board.controller;

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

import com.ssafy.board.HomeController;
import com.ssafy.board.model.GuestBookDto;
import com.ssafy.board.model.MemberDto;
import com.ssafy.board.model.service.GuestBookService;
import com.ssafy.board.model.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService mservice;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	@RequestMapping(value = "/registerMember", method = RequestMethod.POST)
	public String registerMember(MemberDto memberDto ,Model model) throws Exception {
		logger.info("Welcome registerMember.");
		mservice.registerMember(memberDto);
		return "index";
	}
	@RequestMapping(value = "/registerMember", method = RequestMethod.GET)
	public String registerMember2(Model model) throws Exception {
		logger.info("Welcome registerMember2.");
		return "regist";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session,MemberDto memberDto ,Model model) throws Exception {
		logger.info("Welcome login.");
		MemberDto login=mservice.login(memberDto);
		if(login!=null) {
			session.setAttribute("login", login);
		}else {
			session.invalidate();
		}
		return "redirect:/guestlist";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session,Model model) throws Exception {
		logger.info("Welcome logout.");
		session.invalidate();
		return "index";
	}
}