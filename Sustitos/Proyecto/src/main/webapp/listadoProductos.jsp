<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Aniadimos la cabecera -->
<c:import url="cabecera.jsp"/>

<!-- Si no existe el array de productos lo crea-->
	<c:if test="${lstProductos == null}">
		<jsp:forward page="servletProductos"/>
	</c:if>

	<!-- Lista de productos -->
	<h1>Productos</h1>
	<form action="ServletAgregarLineaPedidos" method="post">
	
		<table class="table">
			<tr>
		   		<th>Nombre</th>
		   		<th>Precio</th>
		   		<th>Cantidad</th>
		   		<th>Añadir</th>
		   	</tr>		  
			<c:forEach items="${lstProductos}" var="producto">
				<tr>
					<td><c:out value='${producto.nombre}'/></td>
					<td><c:out value='${producto.precio}'/></td>
					<td><input type="number" name="cantidad" ></td>
					<td><button type="sumbit" class="btn btn-danger" name="aniadir" value="${producto.id}">Añadir</button></td>
				</tr>
			</c:forEach>
		</table>
		<button type="sumbit" class="btn btn-danger" name="verCarro">Ver cesta</button>
    </form>
<!-- Aniadimos el footer -->
<c:import url="footer.jsp"/>