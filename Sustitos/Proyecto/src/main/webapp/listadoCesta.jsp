<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Aniadimos la cabecera -->
<c:import url="cabecera.jsp"/>



	<!-- Lista de productos del carro -->
	<h1>Cesta</h1>
	<form action="ServletAgregarLineaPedidos" method="post">
	
		<table class="table">
			<tr>
		   		<th>Nombre</th>
		   		<th>Precio</th>
		   		<th>Cantidad</th>
		   		<th>Cambiar</th>
		   	</tr>		  
			<c:forEach items="${carroCompra}" var="carro">
				<tr>
					<td><c:out value='${carro.nombre}'/></td>
					<td><c:out value='${carro.precio}'/></td>
					<td><c:out value='${carro.cantidad}'/></td>
					<td><button type="submit" class="btn btn-danger" name="borrar" value="${carro.key}">Borrar</button></td>
				</tr>
			</c:forEach>
			<tr>	
				<td colspan="3"><b>TOTAL:</b></td>
				<td colspan="3"><c:out value='${carroCompra.total()}'/>€</td>
			</tr>
		</table>
    </form>
<!-- Aniadimos el footer -->
<c:import url="footer.jsp"/>