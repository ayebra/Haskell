package Datos;

/**
 *
 * @author AndreaY
 */
public class vConsumo {
    private int idConsumo;
    private int idReserva;
    private int idProducto;
    private Double Cantidad;
    private Double Precio_Venta;
    private String Estado;

    public vConsumo() {
    }

    public vConsumo(int idConsumo, int idReserva, int idProducto, Double Cantidad, Double Precio_Venta, String Estado) {
        this.idConsumo = idConsumo;
        this.idReserva = idReserva;
        this.idProducto = idProducto;
        this.Cantidad = Cantidad;
        this.Precio_Venta = Precio_Venta;
        this.Estado = Estado;
    }

    public int getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Double Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getPrecio_Venta() {
        return Precio_Venta;
    }

    public void setPrecio_Venta(Double Precio_Venta) {
        this.Precio_Venta = Precio_Venta;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
}
