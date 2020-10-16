<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2 style="text-align: center;">Customers' Comments on
	${product.productName}</h2>
<hr>

<br>
<br>
<br>
<div class="container">
	<div style="width:200px; height:200px">

		<img  class="card-img-top"
			src="<spring:url value="${product.productImagePath}"/>" alt="Image">
	</div>

	<div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Comment</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="review" items="${reviews}">
					<tr>
						<td>${review.comment}</td>
						<td><a
							href="<spring:url value="/admin/products/comments/${product.productId}"></spring:url>"
							class="btn btn-secondary">do something</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</div>