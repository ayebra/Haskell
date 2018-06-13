package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author AndreaY
 */
public class Conexion {
   
    public String url ="jdbc:mysql://localhost:3306/basereserva?autoReconnect=true&useSSL=false";
    public String user = "root";
    public String pass = "12345";

    public Conexion() {
    }

    public Connection conectar(){
        Connection link = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection(this.url,this.user,this.pass);
             
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        
        return link;
        
    }
    
}
    

