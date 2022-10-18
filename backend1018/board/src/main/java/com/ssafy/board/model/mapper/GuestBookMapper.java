package com.ssafy.board.model.mapper;

import java.util.List;
import com.ssafy.board.model.GuestBookDto;

public interface GuestBookMapper {
	List<GuestBookDto> listArticle() throws Exception;
	void writeArticle(GuestBookDto books) throws Exception;
	GuestBookDto detailArticle(int articleNo) throws Exception;
	void updateArticle(GuestBookDto book) throws Exception;
	
}
