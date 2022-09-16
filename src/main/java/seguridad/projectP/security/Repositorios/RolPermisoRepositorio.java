package seguridad.projectP.security.Repositorios;

import seguridad.projectP.security.Modelos.RolPermiso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RolPermisoRepositorio extends MongoRepository<RolPermiso,String>{
}
