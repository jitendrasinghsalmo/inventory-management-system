package Springboot_2_Project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  private Integer qty;
  
  @ManyToOne
  private Product product;
  @ManyToOne
  private Orders orders;
  
  public Integer getId() {
	return id;
  }
  public void setId(Integer id) {
	this.id = id;
  }
  public Integer getQty() {
	return qty;
  }
  public void setQty(Integer qty) {
	this.qty = qty;
  }
  public Product getProduct() {
	return product;
  }
  public void setProduct(Product product) {
	this.product = product;
  }
  public Orders getOrders() {
	return orders;
  }
  public void setOrders(Orders orders) {
	this.orders = orders;
  }
  
  
}
