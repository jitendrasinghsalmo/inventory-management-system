package Springboot_2_Project.Service;

import java.util.List;
import java.util.Optional;

import Springboot_2_Project.Entity.Product;

public interface ProductService {
	
	public Product save(Product p);
	public List<Product> fetch();
	public Optional<Product> update(Integer id);
	public Product findbyname(String name);
	
	
	

}
