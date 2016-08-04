package model;

public class Product {
	
	String id;	
	String name ;
	PriceDetail currentPrice;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PriceDetail getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(PriceDetail currentPrice) {
		this.currentPrice = currentPrice;
	}	
	
}
