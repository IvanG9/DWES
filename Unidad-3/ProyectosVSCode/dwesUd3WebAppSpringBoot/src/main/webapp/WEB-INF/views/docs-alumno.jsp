<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>

		<div class="container">
		<h1>Documentacion del alumno: </h1>
		<table class="table table-stripped">
			<thead>
				<th> Nombre</th>
				<th> Dni</th>
				<th> Ciclo</th>
				<th> Curso</th>
			</thead>
			<tbody>
					<tr>
						<td>&nbsp; ${alumnoInfo.getNombre_alumno()} &nbsp;</td>
						<td>&nbsp; ${alumnoInfo.getDni_alumno()} &nbsp;</td>
						<td>&nbsp; ${alumnoInfo.getCiclo_alumno()} &nbsp;</td>
						<td>&nbsp; ${alumnoInfo.getCurso_alumno()} &nbsp;</td>
					</tr>
			</tbody>
		</table>
		<br>
		<p>Si desea añadir nueva documentación introduzca los datos:</p>
		<p>
			<font color="red">${errores}</font>
		</p>
		
		<mvc:form method="post" action="add-docAlumno" modelAttribute="docAlumnoEdit" accept-charset="utf-8" enctype="multipart/form-data">
			
			<mvc:errors path="*" cssClass="text-warning" />
			<input name="dni" type="hidden" value="${alumnoInfo.getDni_alumno()}">
			<div class="form-row">
				<div class="col">
					<mvc:label path="id">Id:</mvc:label>
					<mvc:input path="id" type="text" readonly="true" class="form-control" />
					<mvc:label path="comentario">Comentario:</mvc:label><br/>
					<mvc:textarea path="comentario" rows="2" cols="70" />
					<mvc:input path="fichero" type="file" /><form:errors path="fichero" /><br>
				</div>
				<div class="col">
					<mvc:label path="tipo">Tipo:</mvc:label>
					<ul>
					<mvc:radiobuttons path="tipo" items="${opcionesTipoDoc}" element="p" />
					</ul>
				</div>
				<div class="col">
					<br>
					<br>
					<input type="submit" value="Añadir" class="btn-success">
				</div>
			</div>
			
		</mvc:form>
		
		<br>
			<table class="table table-striped">
				<thead>
					<th> Id</th>
					<th> Tipo</th>
					<th> Comentario</th>
				</thead>
				<tbody>
					<c:forEach items="${docsAlumnoList}" var="docAlumno">
						<tr>
							<td>&nbsp; ${docAlumno.getId()} &nbsp;</td>
							<td>&nbsp; ${docAlumno.getTipo()} (${docAlumno.getTipoFichero()}) &nbsp;</td>
							<td>&nbsp; ${docAlumno.getComentario()} &nbsp;</td>
							<td>&nbsp; <a href="descargar-docAlumno/${alumnoInfo.getDni_alumno()}/${docAlumno.getId()}">Descargar</a> &nbsp; </td>
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
