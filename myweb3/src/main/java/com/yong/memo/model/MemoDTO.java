package com.yong.memo.model;

public class MemoDTO {
	
	private int idx;
	private String writer;
	private String content;
	
	
	public MemoDTO() {
		super();
	}

	

	public MemoDTO(int idx, String writer, String content) {
		super();
		this.idx = idx;
		this.writer = writer;
		this.content = content;
	}



	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		String str="idx="+idx+"\n작성자:"+writer+"\n내용:"+content;

		return str;
	}
}
