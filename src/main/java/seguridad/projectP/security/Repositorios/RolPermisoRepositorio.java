package seguridad.projectP.security.Repositorios;

import seguridad.projectP.security.Modelos.RolPermiso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RolPermisoRepositorio extends MongoRepository<RolPermiso,String>{
    @Query("{'id_rol': ?0,'id_permiso': ?1}")
    RolPermiso getPermisoRol(String id_rol,String id_permiso);
}
