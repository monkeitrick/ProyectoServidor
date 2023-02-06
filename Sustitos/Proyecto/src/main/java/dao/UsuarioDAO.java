package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import beans.Usuario;
import conex.ConexPoolBD; 

public class UsuarioDAO {
	private ConexPoolBD gestorBDXml = new ConexPoolBD();
	
	public Usuario buscaUsuario(String email, String password) { 
		Usuario u = null;
		 try{                  		         
			 	Connection con = gestorBDXml.getDataSource().getConnection(); 
	        	String sql = "SELECT * FROM usuario WHERE email = '" + email + "' AND contrasena = '"+ password +"'";
	        	Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);            
	            if(rs.next()) { 
	            	u = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("contrasena"), rs.getString("imagen"), rs.getString("descripcion"), rs.getString("direccion"), rs.getInt("cp"), rs.getString("municipio"), rs.getString("provincia"), rs.getString("pais"), rs.getInt("telefono"), rs.getString("email"), rs.getInt("validado"), rs.getString("strValidado"));
	            }
	            rs.close();
	            st.close();
	            con.close();
	         }
	         catch (Exception e)  {
	             System.err.println("Error en buscaUsuario(Email, password): " + e);
	         } 
		 return u;
	}
	public Usuario validarCadena(String nombre, String cadena) { 
		Usuario u = null;
		 try{                  		         
			 	Connection con = gestorBDXml.getDataSource().getConnection(); 
	        	String sql = "SELECT * FROM usuario WHERE nombre = '" + nombre + "' AND strValidado = '"+ cadena +"'";
	        	Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);            
	            if(rs.next()) { 
	            	u = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("contrasena"), rs.getString("imagen"), rs.getString("descripcion"), rs.getString("direccion"), rs.getInt("cp"), rs.getString("municipio"), rs.getString("provincia"), rs.getString("pais"), rs.getInt("telefono"), rs.getString("email"), rs.getInt("validado"), rs.getString("strValidado"));
	            }
	            rs.close();
	            st.close();
	            con.close();
	         }
	         catch (Exception e)  {
	             System.err.println("Error en validarCadena(nombre, cadena): " + e);
	         } 
		return u;
	}
	public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
	    //La dirección de correo de envío
	    String remitente = "sustitosexpres@gmail.com";
	    //La clave de aplicación obtenida según se explica en este artículo:
	    String claveemail = "aaaSasa2";

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", claveemail);    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, claveemail);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	  }
}
 