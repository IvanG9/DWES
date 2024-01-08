<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>

		<div class="container">
		<h1>Log de errores: ${filtro}</h1>
		<form action="filt-error" method="post">
			<div class="form-row">
				<div class="col">
					<label>Filtrar por: </label>
					<select name="campoFiltro" required class="form-control">
						<option>Id</option>
						<option>Tipo</option>
						<option>Explicacion</option>
					</select>
				</div>
				<div class="col">
					<label>Como: </label>
					<input type="text" name="filtro" id="filtro" class="form-control">
				</div>
				<div class="col">
					<input type="submit" value="Filtrar" class="btn btn-success">
				</div>
			</div>
		</form>
		<br>
		<table class="table table-stripped">
			<thead>
				<th> <a class="nav-link" href="list-error?orden=id">Id</a></th>
				<th> <a class="nav-link" href="list-error?orden=tipo">Tipo</a></th>
				<th> <a class="nav-link" href="list-error?orden=explicacion">Explicación</a></th>
				<th> Acción</th>
			</thead>
			<tbody>
				<c:forEach items="${errores}" var="error">
					<tr>
						<td> ${error.getId()} </td>
						<td> ${error.getTipo()} </td>
						<td> ${error.getExplicacion()} </td>
						<td><a class="btn btn-danger" href="del-error?id=${error.getId()}"> Borrar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
<%@ include file="../jspf/footer.jspf" %>

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>

	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	

</body>
</html>
