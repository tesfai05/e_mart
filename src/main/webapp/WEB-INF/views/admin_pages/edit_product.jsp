<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h2 style="text-align: center;">Edit Product Form</h2>
<hr>

<form:form modelAttribute="product" action="/e-mart/admin/products/edit/${product.productId}" method="POST">
	<form:hidden path="productId"/>
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="productName">Product Name</label>
			<form:input type="text" class="form-control" path="productName" />
			<form:errors path="productName" cssClass="error" />
		</div>
		<div class="form-group col-md-4">
			<label for="category">Category</label>
			<form:select path="category.categoryName" class="form-control">
				<form:option value="" label="Select Category" />
				<form:options items="${categories}" />
			</form:select>
			<form:errors path="category.categoryName" cssClass="error" />
		</div>
	</div>

	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="productImagePath">Product Image</label>
			<form:input type="text" class="form-control" path="productImagePath" />
			<form:errors path="productImagePath" cssClass="error" />
		</div>

		<div class="form-group col-md-4">
			<label for="unitPrice">Unit Price</label>
			<form:input type="text" class="form-control" path="unitPrice"
				placeholder="0.0" />
			<form:errors path="unitPrice" cssClass="error" />
		</div>
	</div>

	<div class="form-group">
		<label for="description">Description</label>
		<form:input type="textarea" class="form-control" path="description" />
		<form:errors path="description" cssClass="error" />
	</div>

	<input type="submit" class="btn btn-primary" value="Save Product" />
</form:form>