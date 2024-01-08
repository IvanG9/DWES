<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>

	<div class="container">
		<h1>Alumno a Borrar: </h1>
		<p><font color="red">${errores}</font></p>
		<mvc:form action="update-alumno" method="post" modelAttribute="alumnoEdit" accept-charset="utf-8">
			<div class="form-row">
				<div class="col">
					<mvc:label path="nombre">Nombre:</mvc:label>
					<mvc:input type="text" path="nombre" name="nombre" id="nombre" class="form-control" />
					<mvc:errors path="nombre" cssClass="text-warning" />
				</div>
				<div class="col">
					<mvc:label path="dni">Dni:</mvc:label>
					<mvc:input type="text" path="dni" name="dni" id="dni" readonly="true" class="form-control" />
					<mvc:errors path="dni" cssClass="text-warning" />
				</div>
			</div>
			<div class="form-row">
				<div class="col">
					<mvc:label path="edad">Edad:</mvc:label>
					<mvc:input type="number" path="edad" name="edad" id="edad" class="form-control" />
				</div>
				<div class="col" >
					<mvc:label path="ciclo">Ciclo:</mvc:label>
					<mvc:input path="ciclo" type="text" name="ciclo" id="ciclo" class="form-control" />
				</div>
				<div class="col">
					<mvc:label path="curso">Curso:</mvc:label>
					<mvc:input path="curso" type="number" name="curso" id="curso" class="form-control" />
				</div>
			</div>
			<br/>
			<div class="form-row">
				<div class="col">
					<mvc:checkbox path="erasmus"/>
					<mvc:label path="erasmus">Alumno en Erasmus</mvc:label>
				</div>
				<div class="col">
					<mvc:label path="interesadoEn">Interesado en:</mvc:label><br/>
					<mvc:checkboxes path="interesadoEn" items="${interesadoEnLista}"/>
				</div>
				<div class="col">
					<mvc:label path="lenguajeFavorito">Lenguaje favorito:</mvc:label>
					<mvc:checkbox path="lenguajeFavorito" value="Java" />&nbsp;Java
				</div>
			</div>
			<div class="form-row">
				<div class="col">
					<mvc:label path="genero">Género:</mvc:label><br/>
					<mvc:radiobutton path="genero" value="Hombre" /> Hombre <br/>
					<mvc:radiobutton path="genero" value="Mujer" /> Mujer
				</div>
				<div class="col">
					<mvc:label path="horario">Horario:</mvc:label><br/>
					<mvc:select path="horario">
						<mvc:options items="${horarioLista}" />
					</mvc:select>
				</div>
				<div class="col">
					<mvc:label path="pais">Pais:</mvc:label><br/>
					<mvc:select path="pais">
						<mvc:option value="-" label="Ninguno" />
						<mvc:options items="${paisLista}" />
					</mvc:select>
				</div>
				<div class="col">
					<mvc:label path="matriculadoEn">Matriculado en:</mvc:label><br/>
					<mvc:select path="matriculadoEn" items="${moduloLista}" itemValue="id" itemLabel="nombre">
					</mvc:select>
				</div>
			</div>
			<div class="form-row">
				<div class="col">
					<mvc:label path="hobbies">Hobbies:</mvc:label><br/>
					<mvc:textarea path="hobbies" rows="3" cols="70" />
				</div>
			</div>
			<mvc:hidden path="user" />
			<mvc:hidden path="ts" />
			<br><input type="submit" value="Modificar" class="btn btn-danger">
			<a href="list-alumno"><input type="button" value="Cancelar" class="btn btn-success"></a>
		</mvc:form>
	</div>
	
<%@ include file="../jspf/footer.jspf" %>

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>

	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	

</body>
</html>