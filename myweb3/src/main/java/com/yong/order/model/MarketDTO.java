package com.yong.order.model;

public class MarketDTO {

	private String marketname;
	private String marketaddr;
	private String markettel;
	
	
	
	public MarketDTO(String marketname, String marketaddr, String markettel) {
		super();
		this.marketname = marketname;
		this.marketaddr = marketaddr;
		this.markettel = markettel;
	}



	public MarketDTO() {
		super();
	}



	public String getMarketname() {
		return marketname;
	}



	public void setMarketname(String marketname) {
		this.marketname = marketname;
	}



	public String getMarketaddr() {
		return marketaddr;
	}



	public void setMarketaddr(String marketaddr) {
		this.marketaddr = marketaddr;
	}



	public String getMarkettel() {
		return markettel;
	}



	public void setMarkettel(String markettel) {
		this.markettel = markettel;
	}
	
	
	
	
}
