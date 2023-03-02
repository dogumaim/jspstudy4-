package com.yong.order.model;

import java.util.*;

public class OrderDTO {

	
	private List<ProductDTO> products;
	private MarketDTO marketinfo;
	
	public OrderDTO() {
		super();
	}

	public OrderDTO(List<ProductDTO> products, MarketDTO marketinfo) {
		super();
		this.products = products;
		this.marketinfo = marketinfo;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	public MarketDTO getMarketinfo() {
		return marketinfo;
	}

	public void setMarketinfo(MarketDTO marketinfo) {
		this.marketinfo = marketinfo;
	}
	
	
	
	
}
