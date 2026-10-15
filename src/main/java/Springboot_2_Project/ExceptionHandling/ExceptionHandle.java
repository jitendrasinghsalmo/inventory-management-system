package Springboot_2_Project.ExceptionHandling;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Global exception handle


@RestControllerAdvice
public class ExceptionHandle {
@ExceptionHandler(RuntimeException.class)
public String ExceptionH(RuntimeException e) {
return e.getMessage();
   }
@ExceptionHandler(InsufficientStockException.class)
public String ExceptionHa(InsufficientStockException e) {
return e.getMessage();
   }
}
