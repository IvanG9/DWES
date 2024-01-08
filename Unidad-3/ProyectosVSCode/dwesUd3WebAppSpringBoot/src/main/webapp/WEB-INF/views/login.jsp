<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>

	<div class="container">
		<p>
			<font color="red">${errores}</font>
		</p>
		<mvc:form method="post" action="login" modelAttribute="usuario">
			<mvc:label path="nickname">Introduzca su usuario:</mvc:label>
			<mvc:input path="nickname" type="text" class="form-control" />
			<mvc:errors path="nickname" cssClass="text-warning" />
			<mvc:label path="password">Introduzca su contraseña:</mvc:label>
			<mvc:password path="password" class="form-control" />
			<mvc:errors path="password" cssClass="text-warning" /><br/>
			<input type="submit" value="Login" class="btn btn-success" />
		</mvc:form>
	</div>

<%@ include file="../jspf/footer.jspf" %>

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>
