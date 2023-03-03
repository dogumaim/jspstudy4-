package com.yong.free.model;

import java.util.*;

public interface FreeDAO {

	/**게시판 보기 관련 메서드*/
	public ArrayList<FreeDTO> freeList();
	/**게시글 등록하기 관련 메서드*/
	public int freeWrite(FreeDTO dto);	
}
