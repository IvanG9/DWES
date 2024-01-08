<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<div class="container">
		<p>Introduzca los datos del nuevo modulo: </p>
		<p><font color="red">${errores}</font></p> 
		<mvc:form action="add-modulo" method="post" modelAttribute="modulo">
			<div class="form-row">
				<div class="col">
					<mvc:label path="id">Id:</mvc:label>
					<mvc:input path="id" type="number" name="id" id="id" class="form-control" required="required"/>
				</div>
				<div class="col">
					<mvc:label path="nombre">Nombre:</mvc:label>
					<mvc:input path="nombre" type="text" name="nombre" id="nombre" class="form-control" required="required"/>
				</div>
			</div>
			<div class="form-row">
				<div class="col">
					<mvc:label path="horas">Horas:</mvc:label>
					<mvc:input path="horas" type="number" name="horas" id="horas" class="form-control" required="required"/>
				</div>
				<div class="col" >
					<mvc:label path="abreviatura">Abreviatura:</mvc:label>
					<mvc:input path="abreviatura" type="text" name="abreviatura" id="abreviatura" class="form-control" required="required"/>
				</div>
			</div>
			<br><input type="submit" value="Añadir" class="btn btn-success">
		</mvc:form>
	</div>