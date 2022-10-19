package com.ssafy.edu.board.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.board.model.GuestBook;
import com.ssafy.edu.board.model.mapper.GuestBookMapper;



@Transactional(readOnly=true)
@Service
public class GuestServiceImpl implements GuestService {

	
	@Autowired
	SqlSession sqlSession;
	
	@Override	
	public List<GuestBook> listArticle() throws Exception {
		GuestBookMapper gmapper = sqlSession.getMapper(GuestBookMapper.class);
		List<GuestBook> list = gmapper.listArticle();
		return list;
	}

	@Override
	public GuestBook detailArticle(int articleNo) throws Exception {
		GuestBookMapper gmapper = sqlSession.getMapper(GuestBookMapper.class);
		GuestBook book = gmapper.detailArticle(articleNo);
		return book;
	}

	@Override
	@Transactional
	public void writeArticle(GuestBook book) throws Exception {
		GuestBookMapper gmapper = sqlSession.getMapper(GuestBookMapper.class);
		gmapper.writeArticle(book);
	}

	@Override
	@Transactional
	public void guestUpdate(GuestBook book) throws Exception {
		GuestBookMapper gmapper = sqlSession.getMapper(GuestBookMapper.class);
		gmapper.guestUpdate(book);

	}

	@Override
	public void guestDelete(int articleNo) throws Exception {
		GuestBookMapper gmapper = sqlSession.getMapper(GuestBookMapper.class);
		gmapper.guestDelete(articleNo);

	}

}
