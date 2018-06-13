package Logica;

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
public class fProducto {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer TotalRegistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Producto","Descripción","Unidad Medida","Precio Venta"};
        String [] registro = new String [5];
        
        TotalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select * from producto where nombre like'%"+ buscar + "%' order by idProducto desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idProducto");
                registro [1] = rs.getString("Nombre");
                registro [2] = rs.getString("Descripcion");
                registro [3] = rs.getString("Unidad_Medida");
                registro [4] = rs.getString("Precio_Venta");
                
                TotalRegistros = TotalRegistros + 1;
                modelo.addRow(registro);
         
        }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public boolean insertar (vProducto dts){
        sSQL = "insert into Producto (Nombre,Descripcion,Unidad_Medida,Precio_Venta)" +
                "values (?,?,?,?)";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getUnidad_Medida());
            pst.setDouble(4, dts.getPrecio_Venta());
     
            
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
    
      public boolean editar (vProducto dts){
          sSQL = "update producto set Nombre=?,Descripcion=?,Unidad_Medida=?,Precio_Venta=?"+
                  " where idProducto=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getUnidad_Medida());
            pst.setDouble(4, dts.getPrecio_Venta());
            
            pst.setInt(5, dts.getIdProducto());
            
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
      
      public boolean eliminar (vProducto dts){
          sSQL = "delete from producto where idProducto=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
          
            pst.setInt(1, dts.getIdProducto());
            
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
    
