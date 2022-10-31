package seguridad.projectP.security.Repositorios;

import seguridad.projectP.security.Modelos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UsuarioRepositorio extends MongoRepository<Usuario, String>{
    @Query("{'user': ?0}")
    public Usuario getUserByEmail(String user);

    @Query("{'cedula': ?0}")
    public Usuario getUserById(String cedula);
}
