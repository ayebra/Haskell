package Datos;

/**
 *
 * @author AndreaY
 */
public class vCliente extends vPersona {
    
    private String Codigo_Cliente;

    public vCliente() {
    }

    public vCliente(String Codigo_Cliente) {
        this.Codigo_Cliente = Codigo_Cliente;
    }

    public String getCodigo_Cliente() {
        return Codigo_Cliente;
    }

    public void setCodigo_Cliente(String Codigo_Cliente) {
        this.Codigo_Cliente = Codigo_Cliente;
    }
    
    

}
