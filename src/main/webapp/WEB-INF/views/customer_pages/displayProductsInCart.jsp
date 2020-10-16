<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h2>${customerName} : Lists of Items in your cart </h2>


<table class="table ">
  <thead>
    <tr class="headings">
      <th class="product">Item</th>
      <th class="price">Price</th>
      <th class="quantity">Quantity</th>
      <th class="price">Total</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="cartItem" items="${CartItems}">
      <tr>
        <td class="product">${cartItem.product.productName}</td>
        <td class="price">${cartItem.product.unitPrice}</td>
        <td class="quantity">${cartItem.itemQuantity}</td>
        <td class="price">${cartItem.totalItemPrice}</td>

      </tr>
    </c:forEach>
  </tbody>
</table>
<h4>your total amount so far:$ ${totalAmount}</h4>
<a class="btn btn-primary" href="<spring:url value="/customer/products/list" />" > Back To Products</a>

<a class="btn btn-primary" href="<spring:url value="/customer/checkOut" />" > Checkout</a>