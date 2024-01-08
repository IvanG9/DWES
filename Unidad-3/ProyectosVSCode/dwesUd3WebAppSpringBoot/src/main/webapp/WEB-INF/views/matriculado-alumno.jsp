<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>

		<div class="container">
		<h1>Alumnos del Modulo: </h1>
		<table class="table table-stripped">
			<thead>
				<th> <a class="nav-link">Id</a></th>
				<th> <a class="nav-link">Nombre</a></th>
				<th> <a class="nav-link">Horas</a></th>
				<th> <a class="nav-link">Abreviatura</a></th>
			</thead>
			<tbody>
					<tr>
						<td> ${modulo.getId()} </td>
						<td> ${modulo.getNombre()} </td>
						<td> ${modulo.getHoras()} </td>
						<td> ${modulo.getAbreviatura()} </td>
					</tr>
			</tbody>
		</table>
		<br>
		<table class="table table-stripped">
			<thead>
				<th> <a class="nav-link">Dni</a></th>
				<th> <a class="nav-link">Nombre</a></th>
				<th> <a class="nav-link">Edad</a></th>
				<th> <a class="nav-link">Accion</a></th>
			</thead>
			<tbody>
				<c:forEach items="${alumnosM}" var="alumno">
					<tr>
						<td> ${alumno.getDni()} </td>
						<td> ${alumno.getNombre()} </td>
						<td> ${alumno.getEdad()} </td>
						<td><a class="btn btn-danger" href="del-alumnoM?dni=${alumno.getDni()}&id=${modulo.getId()}"> Borrar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		Introduzca el nuevo alumno a dar de alta: 
		<br><br>
		Nombre:
		<br><br>
		<mvc:form action="add-alumnoNM" method="post" modelAttribute="nuevoAlumnoModulo" accept-charset="utf-8">
			<mvc:select path="dni">
					<mvc:options items="${alumnosNM}"></mvc:options>
			</mvc:select>
			<mvc:input path="id" type="hidden" value="${modulo.getId()}" />
			<input type="submit" value="Añadir" class="btn btn-success" />
		</mvc:form>
	</div>
<%@ include file="../jspf/footer.jspf" %>

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>

	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	

</body>
</html>
