package com.ssafy.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	private BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		model.addAttribute("lists", boardService.list());

		return "board/list";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String bfwrite(Model model) throws Exception {
		return "board/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@ModelAttribute BoardDto board, Model model) throws Exception {
		logger.debug("write {}", board);
		boardService.write(board);
		return "redirect:/board/list";
	}

	@RequestMapping(value = "/detail/{articleNo}", method = RequestMethod.GET)
	public String detail(@PathVariable int articleNo, Model model) throws Exception {
		model.addAttribute("list", boardService.getBoard(articleNo));
		return "board/detail";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String bfupdate(@ModelAttribute BoardDto board, Model model) throws Exception {
		model.addAttribute("list", board);
		return "board/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute BoardDto board, Model model) throws Exception {
		boardService.update(board);
		return "redirect:/board/detail/" + board.getArticleNo();
	}
	@RequestMapping(value = "/alist", method = RequestMethod.GET)
    public String alist(Model model) throws Exception {
        logger.debug("BoardController ! alist  ");
        return "board/alist";
    }
}
