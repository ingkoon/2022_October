package com.ssafy.board.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.GuestBookDto;
import com.ssafy.board.model.mapper.GuestBookMapper;

@Service
public class GuestBookServiceImpl implements GuestBookService {

	@Autowired
	private SqlSession sqlSession; // 쓰기 직전에 올린다.
	
	@Override
	@Transactional(readOnly = true)
	public List<GuestBookDto> listArticle() throws Exception{
		GuestBookMapper guestBookMapper = sqlSession.getMapper(GuestBookMapper.class);
		List<GuestBookDto> lists = guestBookMapper.listArticle();
		
		return lists;
	}

	@Override
	@Transactional
	public void writeArticle(GuestBookDto books) throws Exception {
		GuestBookMapper guestBookMapper = sqlSession.getMapper(GuestBookMapper.class);
		guestBookMapper.writeArticle(books);
	}

	@Override
	@Transactional(readOnly = true)
	public GuestBookDto detailArticle(int articleNo) throws Exception {
		GuestBookMapper guestBookMapper = sqlSession.getMapper(GuestBookMapper.class);	
		GuestBookDto book = guestBookMapper.detailArticle(articleNo);
		return book;
	}

	@Override
	public void updateArticle(GuestBookDto book) throws Exception {
		GuestBookMapper guestBookMapper = sqlSession.getMapper(GuestBookMapper.class);
		guestBookMapper.updateArticle(book);
					
	}
}