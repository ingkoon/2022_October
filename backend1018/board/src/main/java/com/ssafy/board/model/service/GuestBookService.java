package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.GuestBookDto;

public interface GuestBookService {
		List<GuestBookDto> listArticle() throws Exception;
		void writeArticle(GuestBookDto books) throws Exception;
		GuestBookDto detailArticle(int articleNo) throws Exception;
		void updateArticle(GuestBookDto book) throws Exception;
}
