package Springboot_2_Project.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Springboot_2_Project.Entity.OrderItem;
import Springboot_2_Project.Entity.Orders;
import Springboot_2_Project.Entity.Product;
import Springboot_2_Project.ExceptionHandling.InsufficientStockException;
import Springboot_2_Project.Repository.OrderRepository;
import Springboot_2_Project.Repository.ProductRepository;

@Service
public class OrderServiceImp implements OrderService {
    
	@Autowired
	private OrderRepository orepo;
	@Autowired
	private ProductRepository pRepo;
	
	
	@Override
	public Orders ordered(Integer id, Integer qty) {
		Product p = pRepo.findById(id).orElseThrow(()->new RuntimeException("product is not available"));
		Orders s = new Orders();
		s.setOrderdate(LocalDateTime.now());
		if(p.getQty()<qty) {
			throw new InsufficientStockException("InsufficientStock "+"only "+ p.getQty() + " items available");
		}
		p.setQty(p.getQty()-qty);
		pRepo.save(p);
		OrderItem item = new OrderItem();
		item.setProduct(p);
		item.setQty(qty);
		item.setOrders(s);
		s.setOrderItem(List.of(item));
		return orepo.save(s);
	}
	
	

}
