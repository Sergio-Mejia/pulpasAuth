package seguridad.projectP.security.Repositorios;

import seguridad.projectP.security.Modelos.Permiso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PermisoRepositorio extends MongoRepository<Permiso, String>{
}
