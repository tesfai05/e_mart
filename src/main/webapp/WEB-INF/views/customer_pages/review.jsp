<%--
  Created by IntelliJ IDEA.
  User: wina
  Date: 14/06/2020
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Review</title>
</head>
<body>


<%--@elvariable id="review" type="javafx"--%>
<form:form action="review" method="POST" modelAttribute="review">
    <br>
    <p>Date of Review: ${review.dateOfReview}</p><br>
    <p>Review Id: <form:input id="review" path="reviewId"/></p>
    <form:errors path="reviewId" cssStyle="color : red;"/><br>

    <p>Review: <form:textarea id="comment" path="comment"/></p>
    <form:errors path="dateOfReview" cssStyle="color : red;"/><br>



    <input id="submit" type="submit" value="Process Payment">

</form:form>




</body>
</html>
