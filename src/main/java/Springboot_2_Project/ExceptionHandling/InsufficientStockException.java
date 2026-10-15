package Springboot_2_Project.ExceptionHandling;

public class InsufficientStockException extends RuntimeException {
   private String message;
   public InsufficientStockException(String message){
	   super(message);
   }
}
