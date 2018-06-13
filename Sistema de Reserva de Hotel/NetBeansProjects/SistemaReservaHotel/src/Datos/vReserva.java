package Datos;

import java.sql.Date;

/**
 *
 * @author AndreaY
 */
public class vReserva {
    private int idReserva;
    private int idHabitacion;
    private int idCliente;
    private int idTrabajador;
    private String Tipo_Reserva;
    private Date Fecha_Reserva;
    private Date Fecha_Ingresa;
    private Date Fecha_Salida;
    private Double Costo_Alojamiento;
    private String Estado;

    public vReserva() {
    }

    public vReserva(int idReserva, int idHabitacion, int idCliente, int idTrabajador, String Tipo_Reserva, Date Fecha_Reserva, Date Fecha_Ingresa, Date Fecha_Salida, Double Costo_Alojamiento, String Estado) {
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
        this.Tipo_Reserva = Tipo_Reserva;
        this.Fecha_Reserva = Fecha_Reserva;
        this.Fecha_Ingresa = Fecha_Ingresa;
        this.Fecha_Salida = Fecha_Salida;
        this.Costo_Alojamiento = Costo_Alojamiento;
        this.Estado = Estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getTipo_Reserva() {
        return Tipo_Reserva;
    }

    public void setTipo_Reserva(String Tipo_Reserva) {
        this.Tipo_Reserva = Tipo_Reserva;
    }

    public Date getFecha_Reserva() {
        return Fecha_Reserva;
    }

    public void setFecha_Reserva(Date Fecha_Reserva) {
        this.Fecha_Reserva = Fecha_Reserva;
    }

    public Date getFecha_Ingresa() {
        return Fecha_Ingresa;
    }

    public void setFecha_Ingresa(Date Fecha_Ingresa) {
        this.Fecha_Ingresa = Fecha_Ingresa;
    }

    public Date getFecha_Salida() {
        return Fecha_Salida;
    }

    public void setFecha_Salida(Date Fecha_Salida) {
        this.Fecha_Salida = Fecha_Salida;
    }

    public Double getCosto_Alojamiento() {
        return Costo_Alojamiento;
    }

    public void setCosto_Alojamiento(Double Costo_Alojamiento) {
        this.Costo_Alojamiento = Costo_Alojamiento;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
}
