package Logica;

import Datos.vTrabajador;
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
public class fTrabajador {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer TotalRegistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Nombre","Apellido Paterno","Apellido Materno","Doc","Número Documento","Dirección","Teléfono","Email","Sueldo","Acceso","Login","Clave","Estado"};
        String [] registro = new String [14];
        
        TotalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select p.idPersona,p.Nombre,p.Apellido_Paterno,p.ApellidoMaterno,p.Tipo_Documento,p.Numero_Documento,"
                + "p.Direccion,p.Telefono,p.Email,t.Sueldo,t.Acceso,t.Login,t.Password,t.Estado from Persona p inner join trabajador t "
                + "on p.idPersona = t.idPersona where Numero_Documento like '%"
                + buscar + "%' order by idPersona desc";
        
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
                registro [9] = rs.getString("Sueldo");
                registro [10] = rs.getString("Acceso");
                registro [11] = rs.getString("Login");
                registro [12] = rs.getString("Password");
                registro [13] = rs.getString("Estado");
                
                
                TotalRegistros = TotalRegistros + 1;
                modelo.addRow(registro);
         
        }
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public boolean insertar (vTrabajador dts){
        sSQL = "insert into persona (Nombre,Apellido_Paterno,ApellidoMaterno,Tipo_Documento,Numero_Documento,Direccion,Telefono,Email)" 
                + "values (?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into trabajador (idPersona,Sueldo,Acceso,Login,Password,Estado)" 
                + "values ((select idPersona from persona order by idPersona desc limit 1),?,?,?,?,?,?)";        
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
            
            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());
     
            
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
    
      public boolean editar (vTrabajador dts) {
          sSQL = "update persona set Nombre=?,Apellido_Paterno=?,ApellidoMaterno=?,Tipo_Documento=?,Numero_Documento=?,"
                  + " Direccion=?,Telefono=?,Email=? where idPersona";
         
          sSQL2 = "update trabajador set Sueldo=?,Acceso=?,Login=?,Password=?,Estado=?"
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
            
            pst2.setDouble(1, dts.getSueldo());
            pst2.setString(2, dts.getAcceso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getPassword());
            pst2.setString(5, dts.getEstado());
            pst2.setInt(6, dts.getIdPersona());
     
            
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
            
      public boolean eliminar (vTrabajador dts){
          sSQL = "delete from trabajador where idPersona=?";
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
 
       public DefaultTableModel Login(String Login, String Password){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","Nombre","Apellido Paterno","Apellido Materno","Acceso","Login","Clave","Estado"};
        String [] registro = new String [8];
        
        TotalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select p.idPersona, p.Nombre, p.Apellido_Paterno, p.ApellidoMaterno,"
               + "t.Acceso, t.Login, t.Password, t.Estado from persona p inner join trabajador t "
               + "on p.idPersona = t.idPersona where t.Login like'"
               + Login + "' and t.Password='" + Password + "' and t.Estado='A'";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idPersona");
                registro [1] = rs.getString("Nombre");
                registro [2] = rs.getString("Apellido_Paterno");
                registro [3] = rs.getString("ApellidoMaterno");
                registro [4] = rs.getString("Acceso");
                registro [5] = rs.getString("Login");
                registro [6] = rs.getString("Password");
                registro [7] = rs.getString("Estado");
                
                
                TotalRegistros = TotalRegistros + 1;
                modelo.addRow(registro);
         
        }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
      
}
