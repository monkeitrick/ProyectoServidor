package servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

import beans.Proveedor;
import beans.Usuario;
import dao.UsuarioDAO;

/**
 * Servlet implementation class ProcesaApuesta
 */
public class ServletLogin extends HttpServlet {
	private UsuarioDAO u = new UsuarioDAO();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("login") != null) {
			String email = request.getParameter("email");
			String pass = request.getParameter("password");
			Usuario user = u.buscaUsuario(email, pass);
			if (user == null) {
				request.getSession().setAttribute("mensaje", "El usuario introducido no existe. Rellene los campos nuevamente.");
				response.sendRedirect("login.jsp");  
			}else {
				request.getSession().setAttribute("usuario", user); 
				if (user.getEmail().equals("admin@gmail.com")) {
					response.sendRedirect("listadoUsuarios.jsp");   
				}else if (user.getValidado() != 1) { 
					//u.enviarConGMail(user.getEmail(), "VERIFICACIÓN SUSTITOS", "Cadena: "+user.getStrValidado());
					request.getSession().setAttribute("mensaje", "Revisa tu correo e introduce la clave que se te ha enviado.");
					request.getSession().setAttribute("strValidar", user.getStrValidado());
					response.sendRedirect("login.jsp");  
					
				}else {
					response.sendRedirect("listadoProductos.jsp"); 
				}
			} 
		}
		if (request.getParameter("validar") != null) {
			String cadena = request.getParameter("cadena");
			String nombre = request.getParameter("nombre");
			Usuario user = u.validarCadena(nombre, cadena);
			if (user == null) {
				request.getSession().setAttribute("strValidar", null);
				request.getSession().setAttribute("mensaje", "No se ha podido validar el usuario. Intentelo más tarde.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				
			}
		}
	}
}
