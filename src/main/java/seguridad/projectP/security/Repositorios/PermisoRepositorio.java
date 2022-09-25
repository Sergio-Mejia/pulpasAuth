package seguridad.projectP.security.Repositorios;

import seguridad.projectP.security.Modelos.Permiso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PermisoRepositorio extends MongoRepository<Permiso, String>{
    @Query("{'url':?0,'metodo':?1}")
    Permiso getPermiso(String url, String metodo);
}
