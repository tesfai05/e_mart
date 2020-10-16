package edu.miu.e_mart.service;

import edu.miu.e_mart.domain.CartItem;
import edu.miu.e_mart.domain.ShoppingCart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface IShoppingCartService {
	public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart);
    public ShoppingCart findShoppingCartById(Integer id);
    public List<ShoppingCart> findAllShoppingCart();
    public void updateShoppingCartById(Integer id);
    public void deleteShoppingCartById(Integer id);
    public ShoppingCart getShoppingCart(HttpServletRequest request);
    public int countCurrentProductInCart(Integer id,HttpServletRequest request);
    public String getCustomerName(ShoppingCart shoppingCart);
    List<CartItem> getListsOfItems(ShoppingCart shoppingCart);
}
