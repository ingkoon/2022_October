package com.ssafy.board;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;

public class BoardTest extends UnitTestConfig {

	private final Logger logger = LoggerFactory.getLogger(BoardTest.class);
	
	@Autowired
	private BoardService boardService;

	
}