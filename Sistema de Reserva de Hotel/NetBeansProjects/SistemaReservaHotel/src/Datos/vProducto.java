package Datos;

/**
 *
 * @author AndreaY
 */
public class vProducto {
    private int idProducto;
    private String Nombre;
    private String Descripcion;
    private String Undidad_Medida;
    private Double Precio_Venta;

    public vProducto() {
    }

    public vProducto(int idProducto, String Nombre, String Descripcion, String Unidad_Medida, Double Precio_Venta) {
        this.idProducto = idProducto;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Undidad_Medida = Unidad_Medida;
        this.Precio_Venta = Precio_Venta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getUnidad_Medida() {
        return Undidad_Medida;
        
    }

    public void setUnidad_Medida(String Unidad_Medida) {
        this.Undidad_Medida = Unidad_Medida;
    }

    public Double getPrecio_Venta() {
        return Precio_Venta;
    }

    public void setPrecio_Venta(Double Precio_Venta) {
        this.Precio_Venta = Precio_Venta;
    }
    
   
}
