package seguridad.projectP.security.Controladores;

import seguridad.projectP.security.Modelos.Rol;
import seguridad.projectP.security.Modelos.Usuario;
import seguridad.projectP.security.Repositorios.RolRepositorio;
import seguridad.projectP.security.Repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {

    @Autowired
    private UsuarioRepositorio miRepositorioUsuario;

    @Autowired
    private RolRepositorio miRepositorioRol;

    @PutMapping("{id}/rol/{id_rol}")
    public Usuario asignarRolaUsuario(@PathVariable String id, @PathVariable String id_rol){
        Usuario usuarioActual = this.miRepositorioUsuario
                .findById(id)
                .orElse(null);

        if(usuarioActual == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario buscado no existe");
        }

        Rol rolActual = this.miRepositorioRol
                .findById(id_rol)
                .orElse(null);

        if(rolActual == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El rol solicitado no existe");
        }
        usuarioActual.setIdRol(rolActual);
        return this.miRepositorioUsuario.save(usuarioActual);
    }

    @GetMapping("")
    public List<Usuario> index(){
        return this.miRepositorioUsuario.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Usuario create(@RequestBody Usuario infoUsuario){

        Usuario user = miRepositorioUsuario.getUserById(infoUsuario.getCedula());
        if(user!=null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El usuario ingresado ya est?? registrado");
        }else{
            Rol rolcliente = miRepositorioRol.getRolbyNombre("cliente");
            infoUsuario.setIdRol(rolcliente);
            infoUsuario.setPassword(convertirSHA256(infoUsuario.getPassword()));
            return this.miRepositorioUsuario.save(infoUsuario);
        }
    }

    @GetMapping("{cedula}")
    public Usuario show(@PathVariable String cedula){
        Usuario usuarioActual = this.miRepositorioUsuario
                .findById(cedula)
                .orElse(null);

        if(usuarioActual == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario buscado no existe");
        }

        return usuarioActual;
    }

    @PutMapping("{cedula}")
    public Usuario update(@PathVariable String cedula,@RequestBody Usuario infoUsuario){
        Usuario usuarioActual = this.miRepositorioUsuario
                .findById(cedula)
                .orElse(null);
        if(usuarioActual != null){
            usuarioActual.setUser(infoUsuario.getUser());
            usuarioActual.setPassword( convertirSHA256(infoUsuario.getPassword()));
            usuarioActual.setNombres(infoUsuario.getNombres());
            usuarioActual.setApellidos(infoUsuario.getApellidos());
            usuarioActual.setCiudad(infoUsuario.getCiudad());
            usuarioActual.setDireccion(infoUsuario.getDireccion());
            usuarioActual.setIdRol(infoUsuario.getIdRol());

            return this.miRepositorioUsuario.save(usuarioActual);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario ingresado es incorrecto");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{cedula}")
    public void delete(@PathVariable String cedula){
        Usuario usuarioActual = this.miRepositorioUsuario
                .findById(cedula)
                .orElse(null);
        if(usuarioActual != null){
            this.miRepositorioUsuario.delete(usuarioActual);
        }
    }

    public String convertirSHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();
        for(byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }


    @PostMapping("/validate")
    public Usuario validate(@RequestBody Usuario infoUsuario,
                            final HttpServletResponse response) throws IOException {
        Usuario usuarioActual=this.miRepositorioUsuario
                .getUserByEmail(infoUsuario.getUser());

        if (usuarioActual!=null && usuarioActual.getPassword().equals(convertirSHA256(infoUsuario.getPassword()))) {
            usuarioActual.setPassword("");
            return usuarioActual;
        }else{
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
    }
}
