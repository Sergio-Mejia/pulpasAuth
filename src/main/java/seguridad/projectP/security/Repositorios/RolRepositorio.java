package seguridad.projectP.security.Repositorios;

import org.springframework.data.mongodb.repository.Query;
import seguridad.projectP.security.Modelos.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RolRepositorio extends MongoRepository<Rol, String> {

    @Query("{'nombre': ?0}")
    public Rol getRolbyNombre(String nombre);
}
