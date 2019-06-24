package com.kitri.cafe.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.cafe.board.model.MemoDto;

public interface MemoDao {

	int writeArticle(MemoDto MemoDto);
	List<MemoDto> listArticle(Map<String, String> parameter);
	int modifyArticle(MemoDto MemoDto);
	void deleteArticle(int mseq);
}
