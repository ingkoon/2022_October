package com.ssafy.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.FileInfoDto;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.SizeConstant;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	SqlSession sqlSession;

	@Override
	@Transactional
	public int writeArticle(BoardDto boardDto) throws Exception {
		BoardDao boardDao=sqlSession.getMapper(BoardDao.class);
		boardDao.writeArticle(boardDto);
		int count=0;
		if(boardDto.getFileInfos()!=null && boardDto.getFileInfos().size()>0) {
			for (FileInfoDto dto: boardDto.getFileInfos() ) {
				boardDao.registerFile(dto);
				count++;
			}
		}
		return count;
	}

	@Override
	@Transactional(readOnly = true)
	public List<BoardDto> listArticle(Map<String, String> map) throws Exception {
		BoardDao boardDao=sqlSession.getMapper(BoardDao.class);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if("userid".equals(key))
			key = "b.user_id";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int pgNo = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);

		return boardDao.listArticle(param);
	}

	@Override
	@Transactional(readOnly = true)
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		BoardDao boardDao=sqlSession.getMapper(BoardDao.class);
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = boardDao.getTotalArticleCount(map);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	@Transactional(readOnly = true)
	public BoardDto getArticle(int articleNo) throws Exception {
		BoardDao boardDao=sqlSession.getMapper(BoardDao.class);
		return boardDao.getArticle(articleNo);
	}

	@Override
	@Transactional
	public void updateHit(int articleNo) throws Exception {
		BoardDao boardDao=sqlSession.getMapper(BoardDao.class);
		boardDao.updateHit(articleNo);
	}

	@Override
	@Transactional
	public void modifyArticle(BoardDto boardDto) throws Exception {
		BoardDao boardDao=sqlSession.getMapper(BoardDao.class);
		boardDao.modifyArticle(boardDto);
	}

	@Override
	@Transactional
	public void deleteArticle(int articleNo) throws Exception {
		BoardDao boardDao=sqlSession.getMapper(BoardDao.class);
		boardDao.deleteArticle(articleNo);
	}

}
