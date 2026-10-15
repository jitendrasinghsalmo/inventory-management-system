package Springboot_2_Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Springboot_2_Project.Entity.Orders;


//@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer>{

}
