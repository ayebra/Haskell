package Logica;

import Datos.vHabitacion;
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
public class fHabitacion {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer TotalRegistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Número","Piso","Descripción","Caracteristicas","Precio","Estado","Tipo Habitación",};
        String [] registro = new String [8];
        
        TotalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select * from habitacion where piso like'%"+ buscar + "%' order by idHabitacion";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idHabitacion");
                registro [1] = rs.getString("Numero");
                registro [2] = rs.getString("Piso");
                registro [3] = rs.getString("Descripcion");
                registro [4] = rs.getString("Caracteristicas");
                registro [5] = rs.getString("Precio_Diario");
                registro [6] = rs.getString("Estado");
                registro [7] = rs.getString("Tipo_Habitacion");
                
                TotalRegistros = TotalRegistros + 1;
                modelo.addRow(registro);
         
        }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public boolean insertar (vHabitacion dts){
        sSQL = "insert into habitacion (Numero,Piso,Descripcion,Caracteristicas,Precio_Diario,Estado,Tipo_Habitacion)" +
                "values (?,?,?,?,?,?,?)";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_Diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_Habitacion());
            
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
    
      public boolean editar (vHabitacion dts){
          sSQL = "update habitacion set Numero=?,Piso=?,Descripcion=?,Caracteristicas=?,Precio_Diario=?,Estado=?,Tipo_Habitacion=?"+
                  " where idHabitacion=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_Diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_Habitacion());
            pst.setInt(8, dts.getIdHabitacion());
            
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
      
      public boolean eliminar (vHabitacion dts){
          sSQL = "delete from habitacion where idHabitacion=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
          
            pst.setInt(1, dts.getIdHabitacion());
            
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
        public DefaultTableModel mostrarVista(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Número","Piso","Descripción","Caracteristicas","Precio","Estado","Tipo Habitación",};
        String [] registro = new String [8];
        
        TotalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select * from habitacion where piso like'%"+ buscar + "%' and Estado ='Disponible' order by idHabitacion";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idHabitacion");
                registro [1] = rs.getString("Numero");
                registro [2] = rs.getString("Piso");
                registro [3] = rs.getString("Descripcion");
                registro [4] = rs.getString("Caracteristicas");
                registro [5] = rs.getString("Precio_Diario");
                registro [6] = rs.getString("Estado");
                registro [7] = rs.getString("Tipo_Habitacion");
                
                TotalRegistros = TotalRegistros + 1;
                modelo.addRow(registro);
         
        }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }    
   
        public boolean desocupar (vHabitacion dts){
          sSQL = "update habitacion set Estado=?'Disponible'"+
                  " where idHabitacion=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
          
            pst.setInt(1, dts.getIdHabitacion());
            
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
        
        public boolean ocupar (vHabitacion dts){
          sSQL = "update habitacion set Estado=?'Ocupado'"+
                  " where idHabitacion=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
          
            pst.setInt(1, dts.getIdHabitacion());
            
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
