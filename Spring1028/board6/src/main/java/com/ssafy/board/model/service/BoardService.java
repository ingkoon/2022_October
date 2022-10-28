package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.PageNavigation;

public interface BoardService {

	void write(BoardDto board) throws Exception;
	void update(BoardDto board) throws Exception;
	void delete(int articleNo) throws Exception;
	void updateHit(BoardDto board) throws Exception;
	
	List<BoardDto> list() throws Exception;
	BoardDto getBoard(int articleNo) throws Exception;
	
}
