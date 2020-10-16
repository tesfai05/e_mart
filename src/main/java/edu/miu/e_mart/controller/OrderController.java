package edu.miu.e_mart.controller;
import edu.miu.e_mart.domain.AnOrder;
import edu.miu.e_mart.domain.CartItem;
import edu.miu.e_mart.domain.Customer;
import edu.miu.e_mart.domain.ShoppingCart;
import edu.miu.e_mart.service.IOrderService;
import edu.miu.e_mart.service.IShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.util.List;

@Controller
public class OrderController {
  @Autowired
    private IShoppingCartService shoppingCartService;
  @Autowired
    private  IOrderService orderService;

//    public OrderController(@Qualifier("ShoppingCartService") IShoppingCartService shoppingCartService, @Qualifier("orderService") IOrderService orderService) {
//        this.shoppingCartService = shoppingCartService;
//        this.orderService = orderService;
//    }
    // customer pressed CheckOut
    @RequestMapping("/customer/checkOut")
    public ModelAndView CustomerNeedsToCheckOut(HttpServletRequest request, Model model){
                      // display receipt of the customer
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(request);
                                    shoppingCartService.saveShoppingCart(shoppingCart);
        String customerName = shoppingCartService.getCustomerName(shoppingCart);
        List<CartItem> listOfItemsInCart= shoppingCartService.getListsOfItems(shoppingCart);
                          //ModelAndView if customer bought an item
        ModelAndView mv = new ModelAndView();
        mv.addObject("customerName", customerName);
        if(listOfItemsInCart.size()>0) {// ModelAndView if customer bought an item
            String customerOrderNumber = orderService.stampOrderIdToShoppingCart(shoppingCart);
            mv.setViewName("customer_receipt");
            mv.addObject("customerOrderNumber", customerOrderNumber);
            mv.addObject("listOfItemsInCart",listOfItemsInCart);// item list to model. there is a quantity for every item.
            Double totalAmount = orderService.totalPriceOfTheOrder(shoppingCart);// the total amount of the cart so far
            mv.addObject("totalAmount",totalAmount);
            
        }else {   //ModelAndView if customer didn't buy an item
            mv.setViewName("buyTocheckOut");// customer can not check-out before he buy product return to ListOfProduct
        }

        return mv;

    }
    // customer pressed shopping Cart
    @RequestMapping(value={ "/customer/displayProductsInCart" },method = RequestMethod.GET)
    public String displayProductFromCart(HttpServletRequest request, Model model
    ) {
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(request); // a cart

        List<CartItem> listOfItemsInCart =shoppingCart.getListOfItems();
        if(listOfItemsInCart==null){
            return "buyToCheckOut";
        }
        model.addAttribute("CartItems",listOfItemsInCart);// item list to model. there is a quantity for every item.
        Double totalAmount = orderService.totalPriceOfTheOrder(shoppingCart);// the total amount of the cart so far
        model.addAttribute("totalAmount",totalAmount);


        return "displayProductsInCart";// asking customer to buy or to check out

    }
    @RequestMapping(value={ "/admin/orders" },method = RequestMethod.GET)
    public String getAllOrders(Model model) {
    	
    model.addAttribute("orders", orderService.getAllOrders())	;
    return "order";
    
    }
    
}