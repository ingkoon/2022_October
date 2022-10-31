package com.ssafy.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/admin2")
@CrossOrigin("*")
@Api("어드민 컨트롤러  API V1")
public class AdminUserController2 {

	private static final Logger logger = LoggerFactory.getLogger(AdminUserController2.class);

	private BoardService boardService;

	@Autowired
	public AdminUserController2(BoardService boardService) {
		this.boardService = boardService;
	}

//	public ResponseEnity<String>
	
	@GetMapping(value = "/board/{articleNo}")
	public ResponseEntity<?> boardInfo(@PathVariable("articleNo") String articleNo) {
		logger.debug("boardInfo articleNo : {}", articleNo);
		try {
			BoardDto boardDto = boardService.getBoard(Integer.parseInt(articleNo));
			if (boardDto != null)
				return new ResponseEntity<BoardDto>(boardDto, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping(value = "/board/")
	public ResponseEntity<?> userInfo(@PathVariable("articleNo") String articleNo) {
		logger.debug("boardInfo articleNo : {}", articleNo);
		try {
			BoardDto boardDto = boardService.getBoard(Integer.parseInt(articleNo));
			if (boardDto != null)
				return new ResponseEntity<BoardDto>(boardDto, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
