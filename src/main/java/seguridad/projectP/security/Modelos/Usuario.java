package seguridad.projectP.security.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Usuario {
    @Id
    private String cedula;
    private String user;
    private String password;
    private String nombres;
    private String apellidos;
    private String ciudad;
    private String direccion;
    @DBRef
    private Rol idRol;

    public Usuario(String cedula, String user, String password, String nombres, String apellidos, String ciudad, String direccion) {
        this.cedula = cedula;
        this.user = user;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }
}
