<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>

		<div class="container">
		<h1>Listado de modulos: </h1>
		<mvc:form action="filt-modulo" method="post" modelAttribute="filtroModulo" accept-charset="utf-8">
			<div class="form-row">
				<div class="col">
					<mvc:label path="campo">Modulos con el numero de horas: </mvc:label>
					<mvc:select path="campo">
						<mvc:options items="${listaFiltro}"/>
					</mvc:select>
					<mvc:input type="text" path="filtro" id="filtro" />
					<mvc:errors path="filtro" cssClass="text-warning" />
					<input type="submit" class="btn btn-success" value="Filtrar">
				</div>
			</div>
		</mvc:form>
		<table class="table table-stripped">
			<thead>
				<th> <a class="nav-link" href="sort-modulo?orden=id">Id</a></th>
				<th> <a class="nav-link" href="sort-modulo?orden=nombre">Nombre</a></th>
				<th> <a class="nav-link" href="sort-modulo?orden=horas">Horas</a></th>
				<th> <a class="nav-link" href="sort-modulo?orden=abreviatura">Abreviatura</a></th>
				<th> Acción</th>
			</thead>
			<tbody>
				<c:forEach items="${modulos}" var="modulo">
					<tr>
						<td> ${modulo.getId()} </td>
						<td> ${modulo.getNombre()} </td>
						<td> ${modulo.getHoras()} </td>
						<td> ${modulo.getAbreviatura()} </td>
						<td><a class="btn btn-danger" href="del-modulo?id=${modulo.getId()}"> Borrar</a></td>
						<td><a class="btn btn-success" href="matriculados-modulo?id=${modulo.getId()}"> Alumnos</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
<%@ include file="./add-modulo.jsp" %>
<%@ include file="../jspf/footer.jspf" %>

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>

	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	

</body>
</html>
