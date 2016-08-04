package service;

import java.util.List;

import model.Product;

public interface ProductService {
	
	public Product getProduct(String productId);
	
	public List<Product> getProducts();	
	
	public Product updateProduct(String productId, String price, String currency);
}
