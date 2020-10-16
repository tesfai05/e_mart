<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>




<form:form modelAttribute="credential" action="login" method="post">
<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">



                    <fieldset>

                        <h3 style="text-align:center;">Log in</h3>


                        <div class="form-group">
                            <label for="username">Username</label>
                            <form:input type="text" class="form-control" path="userName" placeholder="Enter Username" />
                            <form:errors path="userName" cssClass="error"/>
                            <small id="username" class="form-text text-muted">We
                                wont share your email.</small>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <form:input type="password" class="form-control" path="password" placeholder="Password" />
                            <form:errors path="password" cssClass="error"/>
                        </div>
                        <input type="submit" class="btn btn-primary" value="Login" />
                    </fieldset>



                </div>
            </div>
        </div>
    </div>
</div>

</form:form>


<%--<div class="container">--%>
<%--	<form:form modelAttribute="credential" action="login" method="post">--%>
<%--		<fieldset>--%>
<%--			<h3 style="text-align:center;">Log in</h3>--%>
<%--			<div class="form-group">--%>
<%--				<label for="username">Username</label>--%>
<%--				<form:input type="text" class="form-control" path="userName"--%>
<%--					placeholder="Enter Username" />--%>
<%--				<small id="username" class="form-text text-muted">We'll--%>
<%--					never share your email with anyone else.</small>--%>
<%--			</div>--%>
<%--			<div class="form-group">--%>
<%--				<label for="password">Password</label>--%>
<%--				<form:input type="password" class="form-control" path="password"--%>
<%--					placeholder="Password" />--%>
<%--			</div>--%>
<%--			<input type="submit" class="btn btn-primary" value="Login" />--%>
<%--		</fieldset>--%>
<%--	</form:form>--%>
<%--</div>--%>
