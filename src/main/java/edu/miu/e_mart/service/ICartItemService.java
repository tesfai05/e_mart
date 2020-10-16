package edu.miu.e_mart.service;

import edu.miu.e_mart.domain.ARole;
//import edu.miu.e_mart.domain.CartItem;
import edu.miu.e_mart.domain.CartItem;
import edu.miu.e_mart.domain.Product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface ICartItemService {
	public CartItem saveCartItem(CartItem cartItem);
    public CartItem findCartItemById(Integer id);
    public List<CartItem> findAllCartItem();
    public void updateCartItemById(Integer id);
    public void deleteCartItemById(Integer id);

    CartItem createCartItem(Product product, HttpServletRequest request);
}