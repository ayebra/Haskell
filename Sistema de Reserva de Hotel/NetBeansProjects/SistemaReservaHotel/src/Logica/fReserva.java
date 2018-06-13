package Logica;

import Datos.vReserva;
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
public class fReserva {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer TotalRegistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID","idHabitacion","Número","idCliente","Cliente","idTrabajador","Trabajador","Tipo Reserva","Fecha Reserva","Fecha Ingreso","Fecha Salida","Costo Alojamiento","Estado"};
        String [] registro = new String [13];
        
        TotalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select r.idReserva,r.idHabitacion,h.Numero,r.idCliente,"+
                "(select Nombre from persona where idPersona = r.idCliente)as clienten,"+
                "(select Apellido_Paterno from persona where idPersona = r.idCliente)as clienteap,"+
                "r.idTrabajador,(select Nombre from persona where idPersona = r.idTrabajador)as trabajadorn,"+
                "(select Apellido_Paterno from persona where idPersona = r.idTrabajador)as trabajadorap,"+
                "r.Tipo_Reserva,r.Fecha_Reserva,r.Fecha_Ingresa,r.Fecha_Salida,"+
                "r.Costo_Alojamiento,r.Estado from reserva r inner join habitacion h on r.idHabitacion = h.idHabitacion where r.Fecha_Reserva like '%"+ buscar + "%' order by idReserva desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idReserva");
                registro [1] = rs.getString("idHabitacion");
                registro [2] = rs.getString("Numero");
                registro [3] = rs.getString("idCliente");
                registro [4] = rs.getString("clienten") + " " + rs.getString("clienteap");
                registro [5] = rs.getString("idTrabajador");
                registro [6] = rs.getString("trabajadorn") + " " + rs.getString("trabajadorap");
                registro [7] = rs.getString("Tipo_Reserva");
                registro [8] = rs.getString("Fecha_Reserva");
                registro [9] = rs.getString("Fecha_Ingresa");
                registro [10] = rs.getString("Fecha_Salida");
                registro [11] = rs.getString("Costo_Alojamiento");
                registro [12] = rs.getString("Estado");
                
                
                TotalRegistros = TotalRegistros + 1;
                modelo.addRow(registro);
         
        }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public boolean insertar (vReserva dts){
        sSQL = "insert into reserva (idHabitacion,idCliente,idTrabajador,Tipo_Reserva,Fecha_Reserva,Fecha_Ingresa,Fecha_Salida,Costo_Alojamiento,Estado)" +
                "values (?,?,?,?,?,?,?,?,?)";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdHabitacion());
            pst.setInt(2, dts.getIdCliente());
            pst.setInt(3, dts.getIdTrabajador());
            pst.setString(4, dts.getTipo_Reserva());
            pst.setDate(5, dts.getFecha_Reserva());
            pst.setDate(6, dts.getFecha_Ingresa());
            pst.setDate(7, dts.getFecha_Salida());
            pst.setDouble(8, dts.getCosto_Alojamiento());
            pst.setString(9, dts.getEstado());  
            
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
    
      public boolean editar (vReserva dts){
          sSQL = "update reserva set idHabitacion=?,idCliente=?,idTrabajador=?,Tipo_Reserva=?,Fecha_Reserva=?,Fecha_Ingresa=?,Fecha_Salida=?,Costo_Alojamiento=?,Estado=?"+
                  " where idReserva=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdHabitacion());
            pst.setInt(2, dts.getIdCliente());
            pst.setInt(3, dts.getIdTrabajador());
            pst.setString(4, dts.getTipo_Reserva());
            pst.setDate(5, dts.getFecha_Reserva());
            pst.setDate(6, dts.getFecha_Ingresa());
            pst.setDate(7, dts.getFecha_Salida());
            pst.setDouble(8, dts.getCosto_Alojamiento());
            pst.setString(9, dts.getEstado());
            
            pst.setInt(10, dts.getIdReserva());
            
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
      
      public boolean Pagar (vReserva dts){
          sSQL = "update Reserva set Estado=?'Pagada'"+
                  " where idReserva=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
           
            
            pst.setInt(1, dts.getIdReserva());
            
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
      
      public boolean eliminar (vReserva dts){
          sSQL = "delete from reserva where idReserva=?";
          
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
          
            pst.setInt(1, dts.getIdReserva());
            
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
    
