package Datos;

/**
 *
 * @author AndreaY
 */
public class vHabitacion {
    private int idHabitacion;
    private String Numero;
    private String Piso;
    private String Descripcion;
    private String Caracteristicas;
    private Double Precio_Diario;
    private String Estado;
    private String Tipo_Habitacion;

    public vHabitacion(int idHabitacion, String Numero, String Piso, String Descripcion, String Caracteristicas, Double Precio_Diario, String Estado, String Tipo_Habitacion) {
        this.idHabitacion = idHabitacion;
        this.Numero = Numero;
        this.Piso = Piso;
        this.Descripcion = Descripcion;
        this.Caracteristicas = Caracteristicas;
        this.Precio_Diario = Precio_Diario;
        this.Estado = Estado;
        this.Tipo_Habitacion = Tipo_Habitacion;
    }

    public vHabitacion() {
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getPiso() {
        return Piso;
    }

    public void setPiso(String Piso) {
        this.Piso = Piso;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCaracteristicas() {
        return Caracteristicas;
    }

    public void setCaracteristicas(String Caracteristicas) {
        this.Caracteristicas = Caracteristicas;
    }

    public Double getPrecio_Diario() {
        return Precio_Diario;
    }

    public void setPrecio_Diario(Double Precio_Diario) {
        this.Precio_Diario = Precio_Diario;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getTipo_Habitacion() {
        return Tipo_Habitacion;
    }

    public void setTipo_Habitacion(String Tipo_Habitacion) {
        this.Tipo_Habitacion = Tipo_Habitacion;
    }
    
    
    
}
