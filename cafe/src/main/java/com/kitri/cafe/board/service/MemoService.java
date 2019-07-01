package com.kitri.cafe.board.service;

import com.kitri.cafe.board.model.MemoDto;

public interface MemoService {
	
	void writeMemo(MemoDto memoDto);
	String listMemo(int seq);
	void modifyMemo(MemoDto MemoDto);
	String deleteMemo(int seq, int mseq);
}
