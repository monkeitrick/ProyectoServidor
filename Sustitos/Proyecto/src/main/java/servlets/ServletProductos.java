package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductoDAO;

/**
 * Servlet implementation class servletProductos
 */

public class ServletProductos extends HttpServlet {
	private ProductoDAO bdProductos;
    
	 @Override
   public void init(ServletConfig config) throws ServletException {
       super.init(config);
       bdProductos = new ProductoDAO();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("lstProductos") == null) {
			request.getSession().setAttribute("lstProductos", bdProductos.lstProductos());
		}
		if((boolean) request.getSession().getAttribute("esAdmin"))
	        request.getRequestDispatcher("listadoProductosAdmin.jsp").forward(request, response);
        request.getRequestDispatcher("listadoProductos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
