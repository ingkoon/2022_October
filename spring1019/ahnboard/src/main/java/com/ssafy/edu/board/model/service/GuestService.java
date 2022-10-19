package com.ssafy.edu.board.model.service;

import java.util.List;

import com.ssafy.edu.board.model.GuestBook;

public interface GuestService {
	List<GuestBook> listArticle() throws Exception;
	GuestBook detailArticle(int articleNo) throws Exception;
	void writeArticle(GuestBook book) throws Exception;
	void guestUpdate(GuestBook book) throws Exception;
	void guestDelete(int articleNo) throws Exception;
	
}
