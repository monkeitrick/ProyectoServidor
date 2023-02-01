package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CarroCompra;
import beans.LineasPedido;
import beans.Pedido;
import beans.Producto;
import beans.Usuario;

/**
 * Servlet implementation class ServletAgregarLineaPedidos
 */
@WebServlet("/ServletAgregarLineaPedidos")
public class ServletAgregarLineaPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAgregarLineaPedidos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		CarroCompra carroCompra;
		
		if (session.getAttribute("carroCompra") == null) {
			carroCompra = new CarroCompra();
			session.setAttribute("carroCompra", carroCompra);
		} else {
			carroCompra = (CarroCompra) session.getAttribute("carroCompra");
		}
		
		if (request.getParameter("verCesta") != null) {
			request.getRequestDispatcher("listadoCesta.jsp").forward(request, response);
		}
		
		
		if (request.getParameter("aniadir") != null) {
			Producto producto = bdPedido.buscaItemPorId(Integer.parseInt(request.getParameter("aniadir")));
			
			Pedido pedido = new Pedido();
			pedido.setIdPedido(bdKeys.siguienteId("pedidos"));
			double importe = item.getPrecio() * Integer.parseInt(request.getParameter("" + item.getIdItem()));
			pedido.setTotal(importe);
			Date date = new Date();
			pedido.setFecha(date);
			Usuario cliente = (Usuario) request.getSession().getAttribute("cliente");
			pedido.setCliente(cliente);
			
			LineasPedido lineaPedido = new LineasPedido();
			lineaPedido.setCantidad(Integer.parseInt(request.getParameter("" + producto.getId())));
			lineaPedido.setProducto(producto);
			carroCompra.aniadeLinea(lineaPedido);
			session.setAttribute("carroCompra", carroCompra);
			
			request.getRequestDispatcher("tienda.jsp").forward(request, response);
		}
		
		if (request.getParameter("continuar") != null) {
			request.getRequestDispatcher("tienda.jsp").forward(request, response);
		}
		
		if (request.getParameter("vaciar") != null) {
			request.getRequestDispatcher("ServletVaciarCesta").forward(request, response);
		}
		
		if (request.getParameter("hacer_pedido") != null) {
			request.getRequestDispatcher("pedir.jsp").forward(request, response);
		}
		
		if (request.getParameter("borrar") != null || request.getParameter("cambiar") != null) {
			String accion = "";
			if (request.getParameter("borrar") != null) {
				accion = "borrar";
				request.getSession().setAttribute("itemTratado", request.getParameter("borrar"));
			} else {
				accion = "cambiar";
				Item item = bdPedido.buscaItemPorId(Integer.parseInt(request.getParameter("cambiar")));
				request.getSession().setAttribute("itemTratado", request.getParameter("cambiar"));
				request.getSession().setAttribute("cantidadNueva", request.getParameter("" + item.getIdItem()));
			}
			request.getSession().setAttribute("accion", accion);
			request.getRequestDispatcher("ServletUpdateLineaPedido").forward(request, response);
		}
	}

}
