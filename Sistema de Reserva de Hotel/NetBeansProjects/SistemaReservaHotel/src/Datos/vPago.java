package Datos;

import java.sql.Date;

/**
 *
 * @author AndreaY
 */
public class vPago {
    
    private int idPago;
    private int idReserva;
    private String Tipo_Comprobante;
    private String Numero_Comprobante;
    private Double igv;
    private Double Total_Pago;
    private Date Fecha_Emision;
    private Date Fecha_Pago;

    public vPago() {
    }

    public vPago(int idPago, int idReserva, String Tipo_Comprobante, String Numero_Comprobante, Double igv, Double Total_Pago, Date Fecha_Emision, Date Fecha_Pago) {
        this.idPago = idPago;
        this.idReserva = idReserva;
        this.Tipo_Comprobante = Tipo_Comprobante;
        this.Numero_Comprobante = Numero_Comprobante;
        this.igv = igv;
        this.Total_Pago = Total_Pago;
        this.Fecha_Emision = Fecha_Emision;
        this.Fecha_Pago = Fecha_Pago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getTipo_Comprobante() {
        return Tipo_Comprobante;
    }

    public void setTipo_Comprobante(String Tipo_Comprobante) {
        this.Tipo_Comprobante = Tipo_Comprobante;
    }

    public String getNumero_Comprobante() {
        return Numero_Comprobante;
    }

    public void setNumero_Comprobante(String Numero_Comprobante) {
        this.Numero_Comprobante = Numero_Comprobante;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotal_Pago() {
        return Total_Pago;
    }

    public void setTotal_Pago(Double Total_Pago) {
        this.Total_Pago = Total_Pago;
    }

    public Date getFecha_Emision() {
        return Fecha_Emision;
    }

    public void setFecha_Emision(Date Fecha_Emision) {
        this.Fecha_Emision = Fecha_Emision;
    }

    public Date getFecha_Pago() {
        return Fecha_Pago;
    }

    public void setFecha_Pago(Date Fecha_Pago) {
        this.Fecha_Pago = Fecha_Pago;
    }
    
    
    
    
}
