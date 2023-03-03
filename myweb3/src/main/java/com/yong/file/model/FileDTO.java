package com.yong.file.model;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {

	private String writer;
	private MultipartFile upload;
	
	public FileDTO(String writer, MultipartFile upload) {
		super();
		this.writer = writer;
		this.upload = upload;
	}

	public FileDTO() {
		super();
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	
	
	
}
