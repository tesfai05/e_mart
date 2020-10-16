package edu.miu.e_mart.service;

//import edu.miu.e_mart.domain.Order;

import java.util.List;

import edu.miu.e_mart.domain.AnOrder;
import edu.miu.e_mart.domain.ShoppingCart;

public interface IOrderService {
	
public AnOrder saveOrder(AnOrder anOrder);
public AnOrder findOrderById(Integer id);
public List<AnOrder> findAllOrder();
public void updateOrderById(Integer id);
public void deleteOrderById(Integer id);
public String stampOrderIdToShoppingCart(ShoppingCart shoppingCart);
Double totalPriceOfTheOrder(ShoppingCart shoppingCart);
public List<AnOrder> getAllOrders();

}