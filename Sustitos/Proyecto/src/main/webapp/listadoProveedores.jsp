<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Aniadimos la cabecera -->
<c:import url="cabecera.jsp"/>

	<!-- Si no existe el array de Proveedores lo crea-->
	<c:if test="${proveedores == null}">
		<jsp:forward page="ServletProveedores"/>
	</c:if>

	<!-- Lista de proveedores -->
	<h1>Proveedores</h1>
	<table class="table">
		<tr>
	   		<th>Nombre Empresa</th>
	   		<th>Encargado</th>
	   		<th>Categoría</th>
            <th>Telefono</th>
            <th>Email</th>
	   	</tr>
	  
		<c:forEach items="${proveedores}" var="proveedor">
			<tr>
				<td><c:out value='${proveedor.nombre}'/></td>
				<td><c:out value='${proveedor.encargado}'/></td>
				<td><c:out value='${proveedor.categoria}'/></td>
				<td><c:out value='${proveedor.telefono}'/></td>
				<td><c:out value='${proveedor.email}'/></td>
			</tr>
		</c:forEach>
	</table>
    
<!-- Aniadimos el footer -->
<c:import url="footer.jsp"/>