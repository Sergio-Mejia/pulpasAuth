package seguridad.projectP.security.Controladores;

import org.springframework.web.server.ResponseStatusException;
import seguridad.projectP.security.Modelos.Permiso;
import seguridad.projectP.security.Repositorios.PermisoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RestController
@RequestMapping("/permiso")
public class ControladorPermiso {

    @Autowired
    private PermisoRepositorio miRepositorioPermiso;

    @GetMapping("")
    public List<Permiso> index(){
        return this.miRepositorioPermiso.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Permiso create(@RequestBody Permiso infoPermiso){
        //Verificar que no exista un permiso con la misma ruta y metodo
        return this.miRepositorioPermiso.save(infoPermiso);
    }

    @GetMapping("/{id}")
    public Permiso show(@PathVariable String id){
        Permiso permisoActual = this.miRepositorioPermiso
                .findById(id)
                .orElse(null);

        if(permisoActual == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El permiso buscado no existe");
        }
        return permisoActual;
    }

    @PutMapping("{id}")
    public Permiso update(@PathVariable String id, @RequestBody Permiso infoPermiso){
        Permiso permisoActual = this.miRepositorioPermiso
                .findById(id)
                .orElse(null);
        if(permisoActual != null){
            permisoActual.setUrl(infoPermiso.getUrl());
            permisoActual.setMetodo(infoPermiso.getMetodo());

            return this.miRepositorioPermiso.save(permisoActual);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El permiso buscado no existe");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Permiso permisoActual = this.miRepositorioPermiso
                .findById(id)
                .orElse(null);
        if(permisoActual != null){
            this.miRepositorioPermiso.delete(permisoActual);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El permiso a eliminar no existe");
        }
    }
}
