package seguridad.projectP.security.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class RolPermiso {

    @Id
    private String _id;
    @DBRef
    private Rol id_rol;
    @DBRef
    private Permiso id_permiso;

    public RolPermiso() {
    }

    public String get_id() {
        return _id;
    }

    public Rol getId_rol() {
        return id_rol;
    }

    public void setId_rol(Rol id_rol) {
        this.id_rol = id_rol;
    }

    public Permiso getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(Permiso id_permiso) {
        this.id_permiso = id_permiso;
    }
}
