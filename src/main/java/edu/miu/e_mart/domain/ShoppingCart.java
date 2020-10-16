
package edu.miu.e_mart.domain;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cart_id")
    private Integer cartId;
    @OneToOne(fetch = FetchType.EAGER)
    private Customer customer;
    @OneToMany(fetch = FetchType.LAZY)
    private List<CartItem> listOfItems= new ArrayList<>();
    public ShoppingCart() {
    }
    public Customer getCustomer() {
        return customer;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartItem> getListOfItems() {
        return listOfItems;
    }

    public void addCartItemToCart(CartItem cartItem) {
        listOfItems.add(cartItem);
    }
}
