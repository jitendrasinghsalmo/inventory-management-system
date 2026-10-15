package Springboot_2_Project.Service;

import Springboot_2_Project.Entity.Orders;
import Springboot_2_Project.Entity.Product;

public interface OrderService {
	
	public Orders ordered(Integer id,Integer qty);

}
