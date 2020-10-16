package edu.miu.e_mart.controller;

import javax.servlet.http.HttpServletRequest;

import edu.miu.e_mart.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.miu.e_mart.domain.CartItem;
import edu.miu.e_mart.domain.Product;
import edu.miu.e_mart.domain.ShoppingCart;
import edu.miu.e_mart.service.ICartItemService;
import edu.miu.e_mart.service.IProductService;
import edu.miu.e_mart.service.IShoppingCartService;

@Controller 
public class ShoppingCartController {
  @Autowired
  private IProductService productService;
  @Autowired
  private ICartItemService cartItemService;
  @Autowired
  private IShoppingCartService shoppingCartService;

  @RequestMapping(value = { "customer/added/productToCart/{id}" }, method = RequestMethod.POST)
  public String addProductToCart(HttpServletRequest request, Model model, //
      @PathVariable("id") Integer id) {
    ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(request); // a cart
    // product must be available in cart
    Product product = productService.findProductById(id);
    if (product != null) {
      CartItem cartItem = cartItemService.createCartItem(product,request);
      shoppingCart.addCartItemToCart(cartItem);

    }

    return "redirect:/customer/products/list";

  }

}