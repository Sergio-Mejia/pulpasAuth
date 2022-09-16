package seguridad.projectP.security.Repositorios;

import seguridad.projectP.security.Modelos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepositorio extends MongoRepository<Usuario, String>{
}
