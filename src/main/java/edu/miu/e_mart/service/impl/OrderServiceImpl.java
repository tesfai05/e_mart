
package edu.miu.e_mart.service.impl;

import edu.miu.e_mart.domain.AnOrder;
import edu.miu.e_mart.domain.CartItem;
import edu.miu.e_mart.domain.ShoppingCart;
import edu.miu.e_mart.repository.IOrderRepository;
import edu.miu.e_mart.service.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
  @Autowired
  private IOrderRepository orderRepository;

  @Override
  public AnOrder saveOrder(AnOrder anOrder) {
    return orderRepository.save(anOrder);
  }

  @Override
  public AnOrder findOrderById(Integer id) {

    Optional<AnOrder> anOrder = orderRepository.findById(id);
    if (anOrder.isPresent())
      return anOrder.get();
    return null;
  }

  @Override
  public List<AnOrder> findAllOrder() {
    return (List<AnOrder>) orderRepository.findAll();
  }

  @Override
  public void updateOrderById(Integer id) {
    // todo

  }

  @Override
  public void deleteOrderById(Integer id) {
    orderRepository.deleteById(id);
  }

  @Override
  public String stampOrderIdToShoppingCart(ShoppingCart shoppingCart) {
//-- -----------   display random order number
    int max = 4000000;
    int min = 155555;
    int range = max - min + 1;
    int rand = (int)(Math.random() * range) + min;
//   --------------------------------------------
    AnOrder order = new AnOrder();
    order.setShoppingCart(shoppingCart);
    order.setOrderNumber("E-mart --" +rand);
    order.setShipper("Fedex");
    order.setShippedDate(LocalDate.now());
    orderRepository.save(order);
    return order.getOrderNumber();
  }

  @Override
  public Double totalPriceOfTheOrder(ShoppingCart shoppingCart) {
    Double totalPriceOfTheOrder = 0.00;
    List<CartItem> cartItems = shoppingCart.getListOfItems();
    if (cartItems != null && cartItems.size() > 0) {
      totalPriceOfTheOrder = cartItems.stream().mapToDouble(item -> item.getProduct().getUnitPrice()).reduce(0.00,
          (a, b) -> a + b);
    }
    return totalPriceOfTheOrder;
  }

@Override
public List<AnOrder> getAllOrders() {
	// TODO Auto-generated method stub
	return (List<AnOrder>) orderRepository.findAll();
}
}
