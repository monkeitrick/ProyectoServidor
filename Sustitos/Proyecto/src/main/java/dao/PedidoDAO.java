package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import beans.Producto;
import conex.ConexPoolBD;

public class PedidoDAO {
	private CategoriaDAO catDao;
	
	// Metodo todosProductos que devuelve un HashMap con todos los productos en venta de la base de datos
	public HashMap<Integer, Producto> todosProductos() {
		HashMap<Integer, Producto> lstProductos = new HashMap<Integer, Producto>();
        try {
        	Connection con = ConexPoolBD.getDataSource().getConnection();
			String sql ="SELECT * FROM productos";
			Statement st= con.createStatement();
	
			ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
            	Producto producto = new Producto();
            	producto.setId(rs.getInt("id"));
            	producto.setNombre(rs.getString("nombre"));
            	producto.setDescripcion(rs.getString("descripcion"));
            	producto.setPrecio(rs.getDouble("precio"));
            	lstProductos.put(producto.getId(), producto);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
        	ex.printStackTrace();
        }
		
		return lstProductos;
	}
	
	// M�todo buscaProductoPorId devuelve el producto cuyo id se recibe como parametro o null
	public Producto buscaProductoPorId(int idproducto) {
		Producto producto = new Producto();
		String sql = "SELECT * FROM producto WHERE id = '" + idproducto + "'";
        try {
        	Connection con = ConexPoolBD.getDataSource().getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            	producto.setId(idproducto);
            	producto.setNombre(rs.getString("nombre"));
            	producto.setDescripcion(rs.getString("descripcion"));
            	producto.setPrecio(rs.getDouble("precio"));
            	catDao = new CategoriaDAO();
            	producto.setCat(catDao.buscaCategoriaPorId(rs.getInt("categoria")));
            }
            rs.close();
            st.close();
            con.close();
        }
        catch (SQLException ex) {
            System.err.println("Error en metodo buscaProductoPorId: " + ex);
        }
		return producto;
	}
	
	// M�todo guardaPedido que recibe un pedido y lo almacena en la bd
	/*public void guardaPedido(Pedido p) {
        String sql = "INSERT INTO pedidos(id, total, fecha, idcliente) VALUES(?, ?, ?, ?)";
        try {
        	Connection con = ConexPoolBD.getDataSource().getConnection();
            PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, p.getId());
            st.setDouble(2, p.getTotal());
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
            st.setString(3, formateador.format(p.getFecha()));
            st.setInt(4, p.getUser().getId());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Error en metodo guardaPedido: " + ex);
        }
	}*/
	
	// M�todo guardaLineaPedido que recibe una l�nea de pedido y la almacena en la bd
	/*public void guardaLineasPedido (LineasPedido l){
        String sql = "INSERT INTO lineaspedido(id, cantidad, idpedido, idpedido) VALUES(?, ?, ?, ?)";
        try {
        	Connection con = ConexPoolBD.getDataSource().getConnection();
            PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, l.getId());
            st.setDouble(2, l.getCantidad());
            st.setInt(3, l.getPedido().getId());
            st.setProducto(4, buscaProductoPorId(l.getProducto().getId()));
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Error en metodo guardaLineaPedido: " + ex);
        }
	}*/
}
