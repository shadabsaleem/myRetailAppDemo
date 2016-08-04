package serviceImpl;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import model.PriceDetail;
import model.Product;
import service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	HashMap<String, Product> products = new HashMap<String, Product>();
	DBCollection collection = null;
	MongoClient mc = null;

	public ProductServiceImpl() {

		
		try {
			mc = new MongoClient("localhost", 27017);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		DB db = mc.getDB("myRetailDb");
		collection = db.getCollection("product");

		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();
		Product product4 = new Product();
		Product product5 = new Product();

		product1.setId("1");
		product1.setName("First Product");
		products.put("1", product1);

		product2.setId("2");
		product2.setName("Second Product");
		products.put("2", product2);

		product3.setId("3");
		product3.setName("Third Product");
		products.put("3", product3);

		product4.setId("4");
		product4.setName("Fourth Product");
		products.put("4", product4);

		product5.setId("5");
		product5.setName("Fifth Product");
		products.put("5", product5);
	}

	@Override
	public Product getProduct(String id) {

		if (products.containsKey(id)) {
			Product product = products.get(id);
			PriceDetail currentPrice = getCurrentPrice(id);
			product.setCurrentPrice(currentPrice);
			System.out.println(product);
			return product;
		} else {
			System.out.println("No records **********");
			return null;
		}

	}

	private PriceDetail getCurrentPrice(String id) {
		PriceDetail pd = new PriceDetail();
		
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("id", id);
			DBCursor cursor = collection.find(whereQuery);
			while (cursor.hasNext()) {
				DBObject record = cursor.next();
				pd.setCurrency((String) record.get("currency"));
				pd.setPrice((String) record.get("price"));
			}
		
		return pd;
	}
	
	@Override
	public Product updateProduct(String id, String newPrice, String newCurrency) {

		if (products.containsKey(id)) {
			Product product = products.get(id);
			PriceDetail currentPrice = getCurrentPrice(id);
			if (!currentPrice.getPrice().equals(newPrice)
					|| !currentPrice.getCurrency().equalsIgnoreCase(newCurrency)) {
				currentPrice = updatePrice(id, newPrice, newCurrency);
			}
			product.setCurrentPrice(currentPrice);
			return product;
		} else {
			System.out.println("No records **********");
			return null;
		}
	}

	
	public PriceDetail updatePrice(String id, String newPrice, String newCurrency) {

			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("id", id);
			newDocument.put("price", newPrice);
			newDocument.put("currency", newCurrency);
			BasicDBObject updateQuery = new BasicDBObject().append("id", id);
			collection.update(updateQuery, newDocument);
			return getCurrentPrice(id);
	}

	@Override
	public List<Product> getProducts() {
		List<Product> productsList = new ArrayList<>();
		Set<String> keys = products.keySet();
		HashMap<String, Product> productsWithPriceMap = new HashMap<String, Product>();
		for (String id : keys) {
			Product product = products.get(id);
			PriceDetail currentPrice = getCurrentPrice(id);
			product.setCurrentPrice(currentPrice);
			productsWithPriceMap.put(id, product);
		}
		Iterator it = productsWithPriceMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			Product product = (Product) pair.getValue();
			productsList.add(product);
		}
		return productsList;
	}	

}
