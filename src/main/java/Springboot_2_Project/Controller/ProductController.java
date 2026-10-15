

//                 Project :-  Order Management System




package Springboot_2_Project.Controller;      

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Springboot_2_Project.Entity.Product;
import Springboot_2_Project.Repository.ProductRepository;
import Springboot_2_Project.Service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService s;
	
	
     @Autowired
	private ProductRepository productRepo;
     
//     @PostMapping("/save")
//     public Product save(@RequestBody Product p) {
//    	     return productRepo.save(p);
//     }
	
  @PostMapping("/saved")
  public Product save(@RequestBody Product p) {
 	     return s.save(p);
  }
	
  @GetMapping("/fetch")
  public List<Product> fetch()
  {
	  return s.fetch();
  }
	
  
  @PutMapping("/update")
  public Optional<Product> update(@RequestParam int id) {
      return s.update(id);
  }
  
  @GetMapping("/findbyname")
  public Product findbyname(@RequestParam String name)
  {
	 return s.findbyname(name);
  }
  
	
}
