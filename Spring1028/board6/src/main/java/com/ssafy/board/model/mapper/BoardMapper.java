package com.ssafy.board.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.FileInfoDto;
import com.ssafy.member.model.MemberDto;

@Mapper
public interface BoardMapper {
	void write(BoardDto board) throws SQLException;
	void update(BoardDto board) throws SQLException;
	void delete(int articleNo) throws SQLException;
	void updateHit(BoardDto board) throws SQLException;
	
	List<BoardDto> list() throws SQLException;
	BoardDto getBoard(int articleNo) throws SQLException;
}
