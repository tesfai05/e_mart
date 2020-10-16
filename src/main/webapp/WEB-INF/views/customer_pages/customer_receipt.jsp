<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div style="text-align:center;">
  <div class="col-xs-10 col-sm-10 col-md-10">
    <address>
      <strong><h1>E-Mart</h1></strong>
      <br>
      Customer Name : ${customerName}
      <br>
      Order Number  : ${customerOrderNumber}
      <br>
      Checkout Complete - Thank You

    </address>
  </div>



  <p><strong>Thank you for your order. Please print this page for your records.</strong></p>

</div>

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
    <c:forEach var="cartItem" items="${listOfItemsInCart}">
      <tr>
        <td class="product">${cartItem.product.productName}</td>
        <td class="price">${cartItem.product.unitPrice}</td>
        <td class="quantity">${cartItem.itemQuantity}</td>
        <td class="price">${cartItem.totalItemPrice}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<h4>your total amount of paid:$ ${totalAmount}</h4>
<a class="btn btn-primary"
  href="<spring:url value="/customer/products/list" />">Products</a>