<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/menuSuperior.jspf" %>

	<div class="container">
		<h1>Bienvenid@ ${usuario.getNombre()}</h1>
		Que nadie se entere de que tu password es ${usuario.getPassword()}
	</div>
	
<%@ include file="../jspf/footer.jspf"%>

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>

	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>
