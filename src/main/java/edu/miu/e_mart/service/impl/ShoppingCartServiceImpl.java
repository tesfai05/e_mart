package edu.miu.e_mart.service.impl;

import edu.miu.e_mart.domain.CartItem;
import edu.miu.e_mart.domain.Customer;
import edu.miu.e_mart.domain.ShoppingCart;
import edu.miu.e_mart.repository.IShoppingCartRepository;
import edu.miu.e_mart.service.IShoppingCartService;
import edu.miu.e_mart.util.Util;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("ShoppingCartService")
public class ShoppingCartServiceImpl implements IShoppingCartService {
  private final IShoppingCartRepository repo;


  public ShoppingCartServiceImpl(IShoppingCartRepository repo) {
    this.repo = repo;
  }

  @Override
  public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
    return repo.save(shoppingCart);
  }

  @Override
  public ShoppingCart findShoppingCartById(Integer id) {
    Optional<ShoppingCart> shoppingCart = repo.findById(id);
    if (shoppingCart.isPresent()) {
      return shoppingCart.get();

    }
    return null;
  }

  @Override
  public List<ShoppingCart> findAllShoppingCart() {
    return (List<ShoppingCart>) repo.findAll();
  }

  @Override
  public void updateShoppingCartById(Integer id) {
    // to do

  }

  @Override
  public void deleteShoppingCartById(Integer id) {
    repo.deleteById(id);
  }

  @Override
  public ShoppingCart getShoppingCart(HttpServletRequest request) {
    return Util.getCartInSession(request);
  }

  @Override
  public int countCurrentProductInCart(Integer id, HttpServletRequest request) {
    ShoppingCart shoppingCart = Util.getCartInSession(request);
    int productQuantity = (int) shoppingCart.getListOfItems()
        .stream()
        .filter(product -> product.getItemId() == id)
        .count();
    return productQuantity;
  }

  @Override
  public String getCustomerName(ShoppingCart shoppingCart) {
    Customer customer = shoppingCart.getCustomer();
    String customerName = "customer has no name";
    if (customer != null && customer.getFirstName() != null) {
      if (customer.getLastName() != null) {
        customerName = customer.getFirstName() + " " + customer.getLastName();
      } else {
        customerName = customer.getFirstName();
      }
    }
    return customerName;

  }

  @Override
  public List<CartItem> getListsOfItems(ShoppingCart shoppingCart) {
    return shoppingCart.getListOfItems();
  }
}