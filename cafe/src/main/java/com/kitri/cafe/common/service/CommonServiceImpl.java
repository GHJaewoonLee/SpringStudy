package com.kitri.cafe.common.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.cafe.common.dao.CommonDao;
import com.kitri.cafe.util.CafeConstance;
import com.kitri.cafe.util.NumberCheck;
import com.kitri.cafe.util.PageNavigation;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int getNextSeq() {
		return sqlSession.getMapper(CommonDao.class).getNextSeq();
	}

	@Override
	public PageNavigation getPageNavigation(Map<String, String> parameter) {
		PageNavigation navigator = new PageNavigation();
		
		int newArticleCount = sqlSession.getMapper(CommonDao.class).getNewArticleCount(Integer.parseInt(parameter.get("bcode")));
		navigator.setNewArticleCount(newArticleCount);

		int totalArticleCount = sqlSession.getMapper(CommonDao.class).getTotalArticleCount(parameter);
		navigator.setTotalArticleCount(totalArticleCount);
		
		int totalPageCount = ((totalArticleCount - 1) / CafeConstance.ARTICLE_SIZE) + 1;
		navigator.setTotalPageCount(totalPageCount);
		
		int pg = NumberCheck.NotNumberToOne(parameter.get("pg"));
		navigator.setNowFirst(pg <= CafeConstance.PAGE_SIZE);
		navigator.setNowEnd((((totalPageCount - 1) / CafeConstance.PAGE_SIZE) * CafeConstance.PAGE_SIZE) < pg);
		navigator.setPageNo(pg);
		
		return navigator;
	}
}
