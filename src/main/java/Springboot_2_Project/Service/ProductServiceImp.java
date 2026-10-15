package Springboot_2_Project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import Springboot_2_Project.Entity.Product;
import Springboot_2_Project.Repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository t1;
	@Override
	public Product save(Product p) {
		
		return t1.save(p);
	}
	@Override
	public List<Product> fetch() {
		// TODO Auto-generated method stub
		return t1.findAll();
	}
	
	@Override
	public Optional<Product> update(Integer id) {

	    Product p = t1.findById(id)
	            .orElseThrow(() -> new RuntimeException("Invalid Id"));

	    p.setName("Vivo");

	    Product updatedProduct = t1.save(p);

	    return Optional.of(updatedProduct);
	}
	
	@Override
	public Product findbyname(String name) {
		
		return t1.findByName(name).orElseThrow(()->new RuntimeException ("invalid name"));
	}
	
	
	

}
