package com.ssafy.board.controller;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.board.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(BoardController.class);

	private final BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {	
		this.boardService = boardService;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list (Model model) throws Exception{
		logger.debug("BoardController  ! list ");			
		model.addAttribute("lists", boardService.list());
		return "board/list";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writePage(Model model) throws Exception{		
		return "board/write";
	}	
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write (Model model) throws Exception{
		logger.debug("BoardController  ! list ");			
		model.addAttribute("lists", boardService.list());
		return "board/list";
	}
}