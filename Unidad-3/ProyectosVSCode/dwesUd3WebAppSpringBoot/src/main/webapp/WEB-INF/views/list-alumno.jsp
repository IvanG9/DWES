<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>

	<div class="container">
	
		<h1>Listado de alumnos: </h1>
		<mvc:form action="filtro-avanzado-alumno" method="post" modelAttribute="filtroAvanzadoAlumno" accept-charset="utf-8">
			<div class="form-row">
				<div class="col">
					<mvc:label path="dni">Dni:</mvc:label>
				</div>
				<div class="col">
					<mvc:label path="ciclo">Ciclo:</mvc:label>
				</div>
				<div class="col">
					<mvc:label path="horario">Horario:</mvc:label>
				</div>
				<div class="col">
					&nbsp;
				</div>
			</div>
			<div class="form-row">
				<div class="col">
					<mvc:select path="dni">
						<mvc:option value="-" label="Ninguno" />
						<mvc:options items="${dniListaAlumnos}" />
					</mvc:select>
				</div>
				<div class="col">
					<mvc:select path="ciclo">
						<mvc:option value="-" label="Ninguno" />
						<mvc:options items="${cicloListaAlumnos}" />
					</mvc:select>
				</div>
				<div class="col">
					<mvc:select path="horario">
						<mvc:option value="-" label="Ninguno" />
						<mvc:options items="${horarioListaAlumnos}" />
					</mvc:select>
				</div>
				<div class="col">
					<input type="submit" class="btn btn-success" value="Filtrar">
				</div>
			</div>
		</mvc:form>
		<br>
		<p>Bienvenido ${nickname}</p>
		<table class="table table-stripped">
			<thead>
				<th> <a class="nav-link" href="sort-alumno?orden=nombre">Nombre</a></th>
				<th> <a class="nav-link" href="sort-alumno?orden=dni">Dni</a></th>
				<th> <a class="nav-link" href="sort-alumno?orden=edadNombre">Edad</a></th>
				<th> <a class="nav-link" href="sort-alumno?orden=cicloNombre">Ciclo</a></th>
				<th> <a class="nav-link" href="sort-alumno?orden=cursoNombre">Curso</a></th>
				<th> <a class="nav-link" href="sort-alumno?orden=erasmus">Erasmus</a></th>
				<th> <a class="nav-link" href="sort-alumno?orden=modificado">Modificado</a></th>
				<th> Acción</th>
			</thead>
			<tbody>
				<c:forEach items="${alumnos}" var="alumno">
					<tr>
						<td> ${alumno.getNombre()} </td>
						<td> ${alumno.getDni()} </td>
						<td> ${alumno.getEdad()} </td>
						<td> ${alumno.getCiclo()} </td>
						<td> ${alumno.getCurso()} </td>
						<td> <input type="checkbox" ${alumno.getErasmusChecked()} disabled> </td>
						<td> ${alumno.getModificado()} </td>
						<td><a class="btn btn-success" href="update-alumno?dni=${alumno.getDni()}"> Modificar</a></td>
						<td><a class="btn btn-danger" href="del-alumno?dni=${alumno.getDni()}"> Borrar</a></td>
						<td><a class="btn btn-success" href="docs-alumno?dni=${alumno.getDni()}"> Documentacion</a></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-success" href="add-alumno">Añadir alumno</a>
	</div>

<%@ include file="../jspf/footer.jspf" %>

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>

	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>
