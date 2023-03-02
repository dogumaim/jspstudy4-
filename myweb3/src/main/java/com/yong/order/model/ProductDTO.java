package com.yong.order.model;

public class ProductDTO {

	private int proidx;
	private String proname;
	private int pronum;
	private String bigo;
	
	
	public int getProidx() {
		return proidx;
	}


	public void setProidx(int proidx) {
		this.proidx = proidx;
	}


	public String getProname() {
		return proname;
	}


	public void setProname(String proname) {
		this.proname = proname;
	}


	public int getPronum() {
		return pronum;
	}


	public void setPronum(int pronum) {
		this.pronum = pronum;
	}


	public String getBigo() {
		return bigo;
	}


	public void setBigo(String bigo) {
		this.bigo = bigo;
	}


	public ProductDTO(int proidx, String proname, int pronum, String bigo) {
		super();
		this.proidx = proidx;
		this.proname = proname;
		this.pronum = pronum;
		this.bigo = bigo;
	}


	public ProductDTO() {
		super();
	}
	
	
	
}
