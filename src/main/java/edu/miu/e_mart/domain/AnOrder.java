package edu.miu.e_mart.domain;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class AnOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private Integer orderId;
    private String orderNumber;
    private LocalDate orderDate=LocalDate.now();
    private LocalDate shippedDate;
    private String shipper;
    private String orderStatus;
    @OneToOne(fetch = FetchType.EAGER)
    private ShoppingCart shoppingCart;
    public AnOrder() {
    }


  public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }


  public LocalDate getShippedDate() {
    return shippedDate;
  }


  public void setShippedDate(LocalDate shippedDate) {
    this.shippedDate = shippedDate;
  }


  public String getShipper() {
    return shipper;
  }


  public void setShipper(String shipper) {
    this.shipper = shipper;
  }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber=orderNumber;
    }

    public String  getOrderNumber() {
        return orderNumber;
    }
}