<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2 style="text-align: center;">Admin Registration Form</h2>
<hr>
<form:form action="" method="POST" modelAttribute="admin">
  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="firstName">First Name</label>
      <form:input type="text" class="form-control" path="firstName" />
      <form:errors path="firstName" cssClass="error" />
    </div>
    <div class="form-group col-md-4">
      <label for="lastName">Last Name</label>
      <form:input type="text" class="form-control" path="lastName" />
      <form:errors path="lastName" cssClass="error" />
    </div>
  </div>

  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="acredential.userName">User Name</label>
      <form:input type="text" class="form-control"
        path="acredential.userName" placeholder="eg. Alex" />
      <form:errors path="acredential.userName" cssClass="error" />
    </div>
    <div class="form-group col-md-4">
      <label for="acredential.password">password</label>
      <form:input type="text" class="form-control"
        path="acredential.password" />
      <form:errors path="acredential.password" cssClass="error" />
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="role.roleType">Role Type</label>
      <form:select class="form-control" path="role.roleType">
        <form:option value="0" label="Select Role" />
        <form:options items="${roles}"  />
      </form:select>
      <form:errors path="role.roleType" cssClass="error" />
    </div>

  </div>
  <h3>Address</h3>
  <div class="form-row">
    <div class="form-group col-md-4">
    <label for="address.street">Street</label>
      <form:input type="text" class="form-control" path="address.street"
        placeholder="Street" />
      <form:errors path="address.street" cssClass="error" />
    </div>
    <div class="form-group col-md-4">
    <label for="address.city">City</label>
      <form:input type="text" class="form-control" path="address.city"
        placeholder="City" />
      <form:errors path="address.city" cssClass="error" />
    </div>

  </div>
  <div class="form-row">
    <div class="form-group col-md-4">
    <label for="address.state">State</label>
      <form:input type="text" class="form-control" path="address.state"
        placeholder="State" />
      <form:errors path="address.state" cssClass="error" />
    </div>
    <div class="form-group col-md-4">
    <label for="address.zipCode">Zip Code</label>
      <form:input type="text" class="form-control" path="address.zipCode"
        placeholder="Zip Code" />
      <form:errors path="address.zipCode" cssClass="error" />
    </div>

  </div>


  <button type="submit" class="btn btn-primary">Register</button>
</form:form>