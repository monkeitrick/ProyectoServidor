<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<c:import url="cabecera.jsp"/>
	<c:if test="${mensaje != null}">
		<p style="color: green">"${mensaje}"</p>
	</c:if>
	<div style="margin: auto; width: 20em;">
		<h2 style="text-align: center; background: LightYellow;">Iniciar Sesion</h2>
		<form action="ServletLogin" method="post">
			<table style="margin: auto; border: 1px solid LightYellow; margin-bottom: 15px">
				<tr>
					<td style="border: 1px solid LightYellow"><label>Email</label></td>
					<td style="border: 1px solid LightYellow"><input type="text" name="usuario"></td>
				</tr>
				<tr>
					<td style="border: 1px solid LightYellow"><label>Password</label></td>
					<td style="border: 1px solid LightYellow"><input type="password" name="password"></td>
				</tr>
			</table>
			<a href="recuperarPass.jsp">¿Olvidaste tu contraseña?</a><br>
			<button type="submit" name="login">Entrar</button>
		</form>
		<c:if test="${mensajeError != null}">
			<script type='text/javascript'>alert("${mensajeError}");</script>
		</c:if>
	</div>
</body>
</html>