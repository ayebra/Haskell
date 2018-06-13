package Logica;

import Datos.vPago;
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
public class fPago {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer TotalRegistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","idReserva","Comprobante","Número","Ivg","Todal","Fecha Emisión","Fecha Pago"};
        String [] registro = new String [8];
        
        TotalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select * from pago where idReserva ="+ buscar + "%' order by idPago desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idPago");
                registro [1] = rs.getString("idReserva");
                registro [2] = rs.getString("Tipo_Comprobante");
                registro [3] = rs.getString("Numero_Comprobante");
                registro [4] = rs.getString("igv");
                registro [5] = rs.getString("Total_Pago");
                registro [6] = rs.getString("Fecha_Pago");
                registro [7] = rs.getString("Fecha_Emision");
                registro [8] = rs.getString("Fecha_Pago");
                
                
                TotalRegistros = TotalRegistros + 1;
                modelo.addRow(registro);
         
        }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public boolean insertar (vPago dts){
        sSQL = "insert into pago (idReserva,Tipo_Comprobante,Numero_Comprobante,igv,Total_Pago,Fecha_Emision,Fecha_Pago)" +
                "values (?,?,?,?,?,?,?)";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            pst.setString(2, dts.getTipo_Comprobante());
            pst.setString(3, dts.getNumero_Comprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotal_Pago());
            pst.setDate(6, dts.getFecha_Emision());
            pst.setDate(7, dts.getFecha_Pago());
     
            
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
    
      public boolean editar (vPago dts){
          sSQL = "update pago set idReserva=?,Tipo_Comprobante=?,Numero_Comprobante=?,igv=?,Tota_Pago=?,Fecha_Emision=?,Fecha_Pago=?"+
                  " where idPago=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            pst.setString(2, dts.getTipo_Comprobante());
            pst.setString(3, dts.getNumero_Comprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotal_Pago());
            pst.setDate(6, dts.getFecha_Emision());
            pst.setDate(7, dts.getFecha_Pago());
            
            pst.setInt(8, dts.getIdPago());
            
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
      
      public boolean eliminar (vPago dts){
          sSQL = "delete from pago where idPago=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
          
            pst.setInt(1, dts.getIdPago());
            
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
    
