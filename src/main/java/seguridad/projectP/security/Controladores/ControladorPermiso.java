package seguridad.projectP.security.Controladores;

import seguridad.projectP.security.Modelos.Permiso;
import seguridad.projectP.security.Repositorios.PermisoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
            return this.miRepositorioPermiso.save(infoPermiso);
        }

    @GetMapping("{_id}")
    public Permiso show(@PathVariable String id){
        Permiso permisoActual = this.miRepositorioPermiso
                .findById(id)
                .orElse(null);
        return permisoActual;
    }

    @PutMapping("{_id}")
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
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{_id}")
    public void delete(@PathVariable String id){
        Permiso permisoActual = this.miRepositorioPermiso
                .findById(id)
                .orElse(null);
        if(permisoActual != null){
            this.miRepositorioPermiso.delete(permisoActual);
        }
    }
}
