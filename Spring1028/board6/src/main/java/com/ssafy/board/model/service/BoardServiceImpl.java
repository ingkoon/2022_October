package com.ssafy.board.model.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.FileInfoDto;
import com.ssafy.board.model.mapper.BoardMapper;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.SizeConstant;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardMapper boardMapper;

	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	@Override
	public void write(BoardDto board) throws Exception {
		boardMapper.write(board);
		
	}

	@Override
	public void update(BoardDto board) throws Exception {
		// TODO Auto-generated method stun
		boardMapper.update(board);
		
	}

	@Override
	public void delete(int articleNo) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.delete(articleNo);
	}

	@Override
	public void updateHit(BoardDto board) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.updateHit(board);
		
	}

	@Override
	public List<BoardDto> list() throws Exception {
		// TODO Auto-generated method stub
		List<BoardDto> list = boardMapper.list();
		return list;
	}

	@Override
	public BoardDto getBoard(int articleNo) throws Exception {
		List<BoardDto> list = boardMapper.list();
		BoardDto board = boardMapper.getBoard(articleNo);
		return board;
	}

}
