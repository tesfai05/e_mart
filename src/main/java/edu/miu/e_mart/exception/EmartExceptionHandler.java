package edu.miu.e_mart.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmartExceptionHandler {

    @ExceptionHandler( ProductNotFoundException.class)
    public String handleProductNotFoundException( ProductNotFoundException e, Model model){
        model.addAttribute("errorMsg", e.getMessage());
        return "public_error";
    }
    
    
    @ExceptionHandler( CategoryNotFoundException.class)
    public String handleCategoryNotFoundException( CategoryNotFoundException e, Model model){
        model.addAttribute("errorMsg", e.getMessage());
        return "public_error";
    }
    
    @ExceptionHandler( CustomerNotFoundException.class)
    public String handleCustomerNotFoundException( CustomerNotFoundException e, Model model){
        model.addAttribute("errorMsg", e.getMessage());
        return "public_error";
    }
   
    @ExceptionHandler( AdminNotFoundException.class)
    public String handleAdminNotFoundException( AdminNotFoundException e, Model model){
        model.addAttribute("errorMsg", e.getMessage());
        return "public_error";
    }
    
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model){
    	model.addAttribute("errorMsg", e.getMessage());
        return "public_error";
    }
}
