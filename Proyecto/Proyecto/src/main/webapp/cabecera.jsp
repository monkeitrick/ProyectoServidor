<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table style="border: 2px solid black; background: gray; width: 100%;">
	<tr>
		<c:choose>
       		<c:when test="${usuario != null}">
       			<td>${usuario.nombre}</td>
       			<td><a href="">Carrito</a></td>
       			<td><a href="">Cerrar Sesión</a><td>
       		</c:when>
       		<c:otherwise>
       			<td><a href="login.jsp">Iniciar Sesión</a></td>
       			<td><a href="registro.jsp">Crear Cuenta</a><td>
       		</c:otherwise>
        </c:choose>
        
    </tr>
</table>