package seguridad.projectP.security.Repositorios;

import seguridad.projectP.security.Modelos.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RolRepositorio extends MongoRepository<Rol, String> {
}
