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
    @DBRef
    private Rol idRol;

    public Usuario(String cedula, String user, String password) {
        this.cedula = cedula;
        this.user = user;
        this.password = password;
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
