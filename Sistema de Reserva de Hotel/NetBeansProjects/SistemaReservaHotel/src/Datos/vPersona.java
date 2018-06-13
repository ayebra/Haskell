package Datos;

/**
 *
 * @author AndreaY
 */
public class vPersona {
    private int idPersona;
    private String Nombre;
    private String Apellido_Paterno;
    private String ApellidoMaterno;
    private String Tipo_Documento;
    private String Numero_Documento;
    private String Direccion;
    private String Telefono;
    private String Email;

    public vPersona() {
    }

    public vPersona(int idPersona, String Nombre, String ApellidoPaterno, String ApellidoMaterno, String Tipo_Documento, String Numero_Documento, String Direccion, String Telefono, String Email) {
        this.idPersona = idPersona;
        this.Nombre = Nombre;
        this.Apellido_Paterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Tipo_Documento = Tipo_Documento;
        this.Numero_Documento = Numero_Documento;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPaterno() {
        return Apellido_Paterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.Apellido_Paterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getTipo_Documento() {
        return Tipo_Documento;
    }

    public void setTipo_Documento(String Tipo_Documento) {
        this.Tipo_Documento = Tipo_Documento;
    }

    public String getNumero_Documento() {
        return Numero_Documento;
    }

    public void setNumero_Documento(String Numero_Documento) {
        this.Numero_Documento = Numero_Documento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
