<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: wina
  Date: 14/06/2020
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<h2 style="text-align: center;">Payment</h2>

<hr>
<%--@elvariable id="payment" type="javafx"--%>
<form:form action="payment" method="POST" modelAttribute="payment">
    <p>Payment ID: <form:input id="paymentIdInput" path="paymentId"/></p>
    <form:errors path="paymentId" cssStyle="color : red;"/><br>

    <p>Card Type: <form:input id="cardTypeInput" path="cardType"/></p>
    <form:errors path="cardType" cssStyle="color : red;"/><br>

    <p>Card Number: <form:input id="cartNumberInput" path="cartNumber"/></p>
    <form:errors path="cartNumber" cssStyle="color : red;" /><br>

    <p>Name On Card: <form:input id="nameOnCardInput" path="nameOnCard"/></p>
    <form:errors path="nameOnCard" cssStyle="color : red;" /><br>

    <p>CCV: <form:input id="ccvInput" path="ccv"/></p><br>
    <form:errors path="ccv" cssStyle="color : red;" />

    <p>Expire Date: <form:input id="cardExpireDateInput" path="cardExpireDate"/></p>
    <form:errors path="cardExpireDate" cssStyle="color : red;" /><br>

    <p>Payment Date: <form:input id="paymentDateInput" path="paymentDate"/></p>
    <form:errors path="paymentDate" cssStyle="color : red;" /><br>

    <input id="submit" type="submit" value="Process Payment">


</form:form>


<%--<form:form action="payment" method="POST" modelAttribute="Payment">--%>

<%--    <form:input id="paymentIdInput" path="paymentId"/><br>--%>

<%--    <form:input id="cardTypeInput" path="cardType"/>--%>

<%--</form:form>--%>