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

import beans.Proveedor;

/**
 * Servlet implementation class ProcesaApuesta
 */
public class ServletProveedores extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //HttpSession session = request.getSession(true);
        String fichero = this.getInitParameter("fichero");
        try {
            String ruta = this.getServletContext().getRealPath(fichero);
            File myObj = new File(ruta);
            Scanner myReader = new Scanner(myObj,"UTF-8");
            ArrayList<String> proveedores = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                proveedores.add(data);
            }
            myReader.close();
            ArrayList<Proveedor> lstProveedores = new ArrayList<Proveedor>();
            for(String proveedor: proveedores){
            	String[] partes = proveedor.split(";");
                Proveedor p = new Proveedor();
                p.setNombre(partes[0]);
                p.setEncargado(partes[1]);
                p.setCategoria(partes[2]);
                p.setTelefono(Integer.parseInt(partes[3]));
                p.setEmail(partes[4]);
                lstProveedores.add(p);
            }
            this.getServletContext().setAttribute("proveedores", lstProveedores);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
	}
}
