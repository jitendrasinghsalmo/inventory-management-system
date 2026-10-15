package Springboot_2_Project.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Springboot_2_Project.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	public Optional<Product> findByName(String name);

}
