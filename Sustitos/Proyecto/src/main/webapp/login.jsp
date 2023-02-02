<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Añadimos la cabecera -->
<c:import url="cabecera.jsp"/>
<c:if test="${mensaje != null}">
	<p style="color: green">"${mensaje}"</p>
</c:if>	
<div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
     <div class="col-12 col-lg-9 col-xl-7">

	<form action="ServletLogin" method="post">
	  <!-- Email input -->
	  <div class="form-outline mb-4">
	  	<label class="form-label" for="email">Email</label>
	    <input type="email" id="email" name="email" class="form-control"/>
	  </div>
	
	  <!-- Password input -->
	  <div class="form-outline mb-4">
	  	<label class="form-label" for="password">Password</label>
	    <input type="password" id="password" class="form-control" name="password"/>
	  </div>
	
	   <div class="col">
	     <!-- Simple link -->
		<a href="recuperarPass.jsp">¿Olvidaste tu contraseña?</a>
	   </div>
	  
	  <!-- Submit button -->
	  <button type="submit" class="btn btn-danger btn-block mb-4" name="login">Entrar</button>
	  <c:if test="${mensajeError != null}">
			<script type='text/javascript'>alert("${mensajeError}");</script>
	  </c:if>
	 
	</form>
  </div>
 </div>
</div>

<!-- Añadimos el footer -->
<c:import url="footer.jsp"/>
