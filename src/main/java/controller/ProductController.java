package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Product;
import service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService ps;

	@RequestMapping("/get/all")
	public List<Product> getProducts() {
		return ps.getProducts();
	}

	@RequestMapping("/get/{id}")
	public Product getProduct(@PathVariable("id") String id) {
		return ps.getProduct(id);
	}
	
	@RequestMapping("/put/{id}/{price}/{currency}")
	public Product updateProduct(@PathVariable("id") String id, @PathVariable("price") String price, @PathVariable("currency") String currency) {
		return ps.updateProduct(id,price,currency);
	}

}
