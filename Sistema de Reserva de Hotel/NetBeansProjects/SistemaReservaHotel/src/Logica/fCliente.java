package Logica;

import Datos.vCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AndreaY
 */
public class fCliente {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer TotalRegistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Nombre","Apellido Paterno","Apellido Materno","Doc","Número Documento","Dirección","Teléfono","Email","Código"};
        String [] registro = new String [10];
        
        TotalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select p.idPersona,p.Nombre,p.Apellido_Paterno,p.ApellidoMaterno,p.Tipo_Documento,p.Numero_Documento," +
                "p.Direccion,p.Telefono,p.Email,c.Codigo_Cliente from persona p inner join cliente c " +
                "on p.idPersona = c.idPersona where Numero_Documento like '%"+
                buscar + "%' order by idPersona desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idPersona");
                registro [1] = rs.getString("Nombre");
                registro [2] = rs.getString("Apellido_Paterno");
                registro [3] = rs.getString("ApellidoMaterno");
                registro [4] = rs.getString("Tipo_Documento");
                registro [5] = rs.getString("Numero_Documento");
                registro [6] = rs.getString("Direccion");
                registro [7] = rs.getString("Telefono");
                registro [8] = rs.getString("Email");
                registro [9] = rs.getString("Codigo_Cliente");
                
                TotalRegistros = TotalRegistros + 1;
                modelo.addRow(registro);
         
        }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public boolean insertar (vCliente dts){
        sSQL = "insert into Persona (Nombre,Apellido_Paterno,ApellidoMaterno,Tipo_Documento,Numero_Documento,Direccion,Telefono,Email)" +
                "values (?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into cliente (idPersona,Codito_Cliente)" +
                "values ((select idPersona from persona order by idPersona desc limit 1,?)";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellidoPaterno());
            pst.setString(3, dts.getApellidoMaterno());
            pst.setString(4, dts.getTipo_Documento());
            pst.setString(5, dts.getNumero_Documento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());
            
             pst2.setString(1, dts.getCodigo_Cliente());
     
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                int n2 = pst2.executeUpdate();
                
                if(n2!=0){
                    return true;
                }
                else{
                    return false;
                }
                
            }
            else{
                return false;
            }
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
      public boolean editar (vCliente dts) {
          sSQL = "update persona set Nombre=?,Apellido_Paterno=?,ApellidoMaterno=?,Tipo_Documento=?,Numero_Documento=?,"
                  + " Direccion=?,Telefono=?,Email=? where idPersona=?";
         
          sSQL2 = "update cliente set Codigo_Cliente=?"
                  + " where idPersona=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellidoPaterno());
            pst.setString(3, dts.getApellidoMaterno());
            pst.setString(4, dts.getTipo_Documento());
            pst.setString(5, dts.getNumero_Documento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());
            pst.setInt(9, dts.getIdPersona());
            
             pst2.setString(1, dts.getCodigo_Cliente());
             pst2.setInt(2, dts.getIdPersona());
     
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                int n2 = pst2.executeUpdate();
                
                if(n2!=0){
                    return true;
                }
                else{
                    return false;
                }
                
            }
            else{
                return false;
            }
        
    }   catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
      }
            
      public boolean eliminar (vCliente dts){
          sSQL = "delete from cliente where idPersona=?";
          sSQL2 = "delete from persona where idPersona=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setInt(1, dts.getIdPersona());
        
            pst2.setInt(1, dts.getIdPersona());
     
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                int n2 = pst2.executeUpdate();
                
                if(n2!=0){
                    return true;
                }
                else{
                    return false;
                }
                
            }
            else{
                return false;
            }
        
    }   catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
}
