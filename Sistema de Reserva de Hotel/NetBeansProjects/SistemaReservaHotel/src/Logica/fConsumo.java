package Logica;

import Datos.vConsumo;
import Datos.vProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AndreaY
 */
public class fConsumo {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer TotalRegistros;
    public Double TotalConsumo;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","idReserva","idProducto","Producto","Cantidad","Precio Venta","Estado"};
        String [] registro = new String [7];
        
        TotalRegistros = 0;
        TotalConsumo = 0.0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select * c.idConsumo, c.idReserva, c.idProducto, p.Nombre, c.Cantidad, c.Precio_Venta" 
                + ", c.Estado from consumo c inner join producto p on c.idProducto = p.idProducto"
                + " where c.idReserva =" + buscar + " order by idConsumo desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idConsumo");
                registro [1] = rs.getString("idReserva");
                registro [2] = rs.getString("idProducto");
                registro [3] = rs.getString("Nombre");
                registro [4] = rs.getString("Cantidad");
                registro [5] = rs.getString("Precio_Venta");
                registro [6] = rs.getString("Estado");
                
                TotalRegistros = TotalRegistros + 1;
                TotalConsumo = TotalConsumo + (rs.getDouble("Cantidad") * rs.getDouble("Precio_Venta"));
                modelo.addRow(registro);
         
        }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public boolean insertar (vConsumo dts){
        sSQL = "insert into consumo (idReserva,idProducto,Cantidad,Precio_Venta,Estado)" +
                "values (?,?,?,?,?)";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            pst.setInt(2, dts.getIdProducto());
            pst.setDouble(3, dts.getCantidad());
            pst.setDouble(4, dts.getPrecio_Venta());
            pst.setString(5, dts.getEstado());
     
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
      public boolean editar (vConsumo dts){
          sSQL = "update consumo set idReserva=?,idProducto=?,Cantidad=?,Precio_Venta=?,Estado=?"+
                  " where idConsumo=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            pst.setInt(2, dts.getIdProducto());
            pst.setDouble(3, dts.getCantidad());
            pst.setDouble(4, dts.getPrecio_Venta());
            pst.setString(5, dts.getEstado());
            
            pst.setInt(6, dts.getIdConsumo());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
      
      public boolean eliminar (vConsumo dts){
          sSQL = "delete from consumo where idConsumo=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
          
            pst.setInt(1, dts.getIdConsumo());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
    
}
    
