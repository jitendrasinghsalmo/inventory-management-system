package Springboot_2_Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Springboot_2_Project.Entity.Orders;
import Springboot_2_Project.Service.OrderService;

@RestController
public class OrdersController {
	@Autowired
   private OrderService o;
    
	@PostMapping("/orderd/{id}")
	public  Orders Orderd(@PathVariable int id,@RequestParam int qty)
	{
		return o.ordered(id,qty);
	}
	
}
