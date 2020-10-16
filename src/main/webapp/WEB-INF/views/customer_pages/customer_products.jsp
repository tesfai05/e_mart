<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2 style="text-align: center;">List of Products for Customer</h2>
<hr>
<br>
<br>
<br>
<div class="form-row">
  <c:forEach var="product" items="${products}">
    <div class="card" style="width: 18rem;">
      <img width="300px" height="300px" class="card-img-top"
        src="<spring:url value="${product.productImagePath}"/>" alt="Image">
      <div class="card-body">
        <h5 class="card-title">${product.productName}</h5>
        <p class="card-title">$${product.unitPrice}</p>
        <p class="card-text">${product.description }</p>
        <div style="display:flex">
          <form:form modelAttribute="product"
            action="/e-mart/customer/added/productToCart/${product.productId}"
            method="POST">
            <input class="btn btn-secondary" type="submit" value="Add To Cart" />
          </form:form> &nbsp;&nbsp;&nbsp;&nbsp;
          <a
            href="<spring:url value="/customer/products/comment/${product.productId}"/>"
            class="btn btn-secondary">Comment</a>

        </div>
      </div>
    </div>
  </c:forEach>
</div>