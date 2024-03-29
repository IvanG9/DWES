<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>

	<div class="container">
		<h1>Imagen del usuario</h1>
		<p>
			<font color="red">${errores}</font>
		</p>
		<img src="imagenUsuario/${loginNickName}" style="width:150px;height:150px;" class="rounded-circle" />
		<br>
		<mvc:form method="post" action="guardar-imagen-usuario" enctype="multipart/form-data" modelAttribute="imagenUsuario">
			<mvc:hidden path="nickname" />
			<mvc:label path="imagen">Puede actualizar la imagen seleccionando una nueva imagen:</mvc:label>
			<mvc:input path="imagen" type="file" /><form:errors path="imagen" /><br>
			<mvc:errors path="imagen" cssClass="text-warning" /><br>
			<button type="submit" class="btn btn-success"><i class="fas fa-user-edit"></i>&nbsp;Actualizar</button>
		</mvc:form>
	</div>
	
	
<%@ include file="../jspf/footer.jspf" %>

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>

	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	

</body>
</html>