
package edu.miu.e_mart.service.impl;

import edu.miu.e_mart.domain.CartItem;
import edu.miu.e_mart.domain.Product;
import edu.miu.e_mart.repository.ICartItemRepository;
import edu.miu.e_mart.service.ICartItemService;
import edu.miu.e_mart.service.IShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("cartItemService")
public class CartItemServiceImpl implements ICartItemService {
   private final ICartItemRepository cartItemRepository;
   @Autowired
    IShoppingCartService shoppingCartService;

    public CartItemServiceImpl(ICartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }


    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem findCartItemById(Integer id) {
        CartItem cartItem = null;
        Optional<CartItem > cartItem1= cartItemRepository.findById(id);
        if( cartItem1.isPresent()){
            return cartItem1.get();
        }
        return cartItem;
    }

    @Override
    public List<CartItem> findAllCartItem() {
        return (List<CartItem>) cartItemRepository.findAll();
    }

    @Override
    public void updateCartItemById(Integer id) {

    }

    @Override
    public void deleteCartItemById(Integer id) {
               cartItemRepository.deleteById(id);
    }

    @Override
    public CartItem createCartItem(Product product, HttpServletRequest request) {
        int quantity = shoppingCartService.countCurrentProductInCart(product.getProductId(), request);
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setItemQuantity(1);
        cartItem.setTotalItemPrice(product.getUnitPrice());
        cartItemRepository.save(cartItem);
        return cartItem;
    }
}
