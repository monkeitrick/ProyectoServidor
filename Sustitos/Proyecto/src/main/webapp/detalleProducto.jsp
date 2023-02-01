<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Añadimos la cabecera -->
<c:import url="cabecera.jsp"/>	
<section class=" gradient-custom">
  <div class="container py-5 h-95">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Datos de Producto</h3>
            <form action="ServletProducto" method="post">

              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                  	<label class="form-label" for="nombre">Nombre del Producto*</label>
                    <input type="text" id="nombre" name="nombre" class="form-control form-control-lg" />
                    
                  </div>

                </div>
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                  	<label class="form-label" for="precioMin">Precio Mínimo *</label>
                    <input type="text" id="precioMin" name="precioMin" class="form-control form-control-lg" />
                  </div>

                </div>
              </div>
              
              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                  	<label class="form-label" for="descripcion">Descripcion del Producto *</label>
                    <input type="text" id="descripcion" name="descripcion" class="form-control form-control-lg" />
                    
                  </div>

                </div>
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                  	<label class="form-label" for="precioMax">Precio Máximo *</label>
                    <input type="text" id="precioMax" name="precioMax" class="form-control form-control-lg" />
                  </div>

                </div>
              </div>
              
              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                  	<label class="form-label" for="numUnidades">Nº de unidades *</label>
                    <input type="text" id="numUnidades" name="numUnidades" class="form-control form-control-lg" />
                    
                  </div>

                </div>
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                  	<label class="form-label" for="tipo">Tipo *</label>
                    <input type="text" id="tipo" name="tipo" class="form-control form-control-lg" />
                  </div>

                </div>
              </div>
              
              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                  	<label class="form-label" for="precioVenta">Precio de venta *</label>
                    <input type="text" id="precioVenta" name="precioVenta" class="form-control form-control-lg" />
                    
                  </div>

                </div>
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                  	<label class="form-label" for="oferta">¿Esta de oferta?</label>
                    <input type="checkbox" id="oferta" name="oferta" />
                  </div>

                </div>
              </div>
           
              <div class="mt-4 pt-2">
              	<button class="btn btn-danger btn-lg" type="submit" name="aniadir">Añadir Producto</button>
              </div>

            </form>
            
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Añadimos el footer -->
<c:import url="footer.jsp"/>
