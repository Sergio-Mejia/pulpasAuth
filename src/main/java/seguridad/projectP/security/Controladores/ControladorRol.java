package seguridad.projectP.security.Controladores;

import seguridad.projectP.security.Modelos.Rol;
import seguridad.projectP.security.Repositorios.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rol")
public class ControladorRol {

    @Autowired
    private RolRepositorio miRepositorioRol;

    @GetMapping("")
    public List<Rol> index(){
        return this.miRepositorioRol.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Rol create(@RequestBody Rol infoRol){
        return this.miRepositorioRol.save(infoRol);
    }

    @GetMapping("{_id}")
    public Rol show(@PathVariable String id){
        Rol rolActual = this.miRepositorioRol
                .findById(id)
                .orElse(null);
        return rolActual;
    }

    @PutMapping("{_id}")
    public Rol update(@PathVariable String id, @RequestBody Rol infoRol){
        Rol rolActual = this.miRepositorioRol
                .findById(id)
                .orElse(null);
        if(rolActual != null){
            rolActual.setNombre(infoRol.getNombre());
            rolActual.setDescripcion(infoRol.getDescripcion());

            return this.miRepositorioRol.save(rolActual);
        }
        else{
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{_id}")
    public void delete(@PathVariable String id){
        Rol rolActual = this.miRepositorioRol
                .findById(id)
                .orElse(null);
        if(rolActual != null){
            this.miRepositorioRol.delete(rolActual);
        }
    }
}
