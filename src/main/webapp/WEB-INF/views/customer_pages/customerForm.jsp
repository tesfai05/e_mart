

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">

	<div class="panel-heading">
		<h3 style="text-align: center;">Customer Registration Form</h3>
	</div>
	<hr>
	<div class="panel-body">
		<form:form action="/e-mart/customer/save" method="post"
			modelAttribute="newCustomer">
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="firstName">First Name</label>
					<form:input type="text" class="form-control" id="firstName"
						path="firstName" placeholder="First Name" />
					<form:errors path="firstName" cssClass="error" />

				</div>
				<div class="form-group col-md-4">
					<label for="lastName">Last Name</label>
					<form:input type="text" class="form-control" id="lastName"
						path="lastName" placeholder="Last Name" />
					<form:errors path="lastName" cssClass="error" />
				</div>
				<div class="form-group col-md-4">
					<form:hidden path="role.roleType" />
				</div>
			</div>
			<h4>Payment Card:</h4>
			<div></div>
			<div class="form-row">

				<div class="form-group col-md-4">
					<label for="payment.nameOnCard">Name On Card</label>
					<form:input type="text" class="form-control"
						id="payment.nameOnCard" path="payment.nameOnCard"
						placeholder="Name on card" />
					<form:errors path="payment.nameOnCard" cssClass="error" />
				</div>
				<div class="form-group col-md-4">
					<label for="payment.cardNumber">Card Number</label>
					<form:input type="text" class="form-control"
						id="payment.cartNumber" path="payment.cartNumber"
						placeholder="Card Number" />
					<form:errors path="payment.cartNumber" cssClass="error" />
				</div>
				<div class="form-group col-md-4">
					<label for="payment.cardType">Card Type</label>
					<form:input type="text" class="form-control" id="payment.cardType"
						path="payment.cardType" placeholder="Card Type" />
					<form:errors path="payment.cardType" cssClass="error" />
				</div>
			</div>

			<div class="form-row">

				<div class="form-group col-md-4">
					<label for="payment.cardExpireDate">Expire Date</label>
					<form:input type="text" class="form-control"
						id="payment.cardExpireDate" path="payment.cardExpireDate"
						placeholder="Card Expire Date" />
					<form:errors path="payment.cardExpireDate" cssClass="error" />
				</div>

				<div class="form-group col-md-4">
					<label for="payment.cvv">CVV</label>
					<form:input type="text" class="form-control" id="payment.cvv"
						path="payment.cvv" placeholder="cvv" />
					<form:errors path="payment.cvv" cssClass="error" />
				</div>

			</div>
			<div class="form-row">

				<div class="form-group col-md-4">
					<label for="acredential.userName">Username</label>
					<form:input type="text" class="form-control"
						id="acredential.userName" path="acredential.userName"
						placeholder="User Name" />
						<form:errors path="acredential.userName" cssClass="error" />
				</div>


				<div class="form-group col-md-4">
					<label for="acredential.password">Password</label>
					<form:input type="password" class="form-control"
						id="acredential.password" path="acredential.password"
						placeholder="password" />
						<form:errors path="acredential.password" cssClass="error" />
				</div>
			</div>
			<h4>Address:</h4>
			<div class="form-row">

				<div class="form-group col-md-4">
					<label for="address.street">Street</label>
					<form:input type="text" class="form-control" id="address.street"
						path="address.street" placeholder="street" />
					<form:errors path="address.street" cssClass="error"/>
				</div>
				<div class="form-group col-md-4">
					<label for="address.city">City</label>
					<form:input type="text" class="form-control" id="address.city"
						path="address.city" placeholder="city" />
					<form:errors path="address.city" cssClass="error" />
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="address.state">State</label>
					<form:input type="text" class="form-control" id="address.state"
						path="address.state" placeholder="state" />
					<form:errors path="address.state" cssClass="error" />
				</div>
				<div class="form-group col-md-4">
					<label for="address.zipCode">Zip Code</label>
					<form:input type="text" class="form-control" id="address.zipCode"
						path="address.zipCode" placeholder="zipcode" />
					<form:errors path="address.zipCode" cssClass="error" />
				</div>
			</div>

			<input type="submit" value="Register" class="btn btn-primary ">
		</form:form>
	</div>
</div>
