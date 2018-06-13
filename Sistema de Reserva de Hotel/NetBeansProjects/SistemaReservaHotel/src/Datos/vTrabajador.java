package Datos;

/**
 *
 * @author AndreaY
 */
public class vTrabajador extends vPersona{
    Double Sueldo;
    String Acceso;
    String Login;
    String Password;
    String Estado;

    public vTrabajador() {
    }

    public vTrabajador(Double Sueldo, String Acceso, String Login, String Password, String Estado) {
        this.Sueldo = Sueldo;
        this.Acceso = Acceso;
        this.Login = Login;
        this.Password = Password;
        this.Estado = Estado;
    }

    public Double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(Double Sueldo) {
        this.Sueldo = Sueldo;
    }

    public String getAcceso() {
        return Acceso;
    }

    public void setAcceso(String Acceso) {
        this.Acceso = Acceso;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
}
