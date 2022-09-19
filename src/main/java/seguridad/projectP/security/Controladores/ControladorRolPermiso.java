package seguridad.projectP.security.Controladores;

import seguridad.projectP.security.Modelos.Permiso;
import seguridad.projectP.security.Modelos.Rol;
import seguridad.projectP.security.Modelos.RolPermiso;
import seguridad.projectP.security.Repositorios.PermisoRepositorio;
import seguridad.projectP.security.Repositorios.RolPermisoRepositorio;
import seguridad.projectP.security.Repositorios.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rolpermiso")
public class ControladorRolPermiso {

    @Autowired
    private RolPermisoRepositorio miRepositorioRolPermiso;

    @Autowired
    private RolRepositorio miRepositorioRol;

    @Autowired
    private PermisoRepositorio miRepositorioPermiso;

    @GetMapping("")
    public List<RolPermiso> index(){
        return this.miRepositorioRolPermiso.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("rol/{id_rol}/permiso/{id_permiso}")
    public RolPermiso create(@PathVariable String id_rol, @PathVariable String id_permiso){
        RolPermiso nuevo = new RolPermiso();
        Rol elRol = this.miRepositorioRol.findById(id_rol).get();
        Permiso elPermiso = this.miRepositorioPermiso.findById(id_permiso).get();

        if(elRol != null && elPermiso != null){
            nuevo.setId_rol(elRol);
            nuevo.setId_permiso(elPermiso);

            return this.miRepositorioRolPermiso.save(nuevo);
        }
        else {
            return null;
        }
    }

    @GetMapping("{_id}")
    public RolPermiso show(@PathVariable String id){
        RolPermiso permisoRolActual = this.miRepositorioRolPermiso
                .findById(id)
                .orElse(null);
        return permisoRolActual;
    }

    @PutMapping("{id}/rol/{id_rol}/permiso/{id_permiso}")
    public RolPermiso update(@PathVariable String id,@PathVariable String id_rol,@PathVariable String id_permiso){
        RolPermiso permisosRolesActual = this.miRepositorioRolPermiso
                .findById(id)
                .orElse(null);
        Rol elRol=this.miRepositorioRol.findById(id_rol).get();
        Permiso elPermiso=this.miRepositorioPermiso.findById(id_permiso).get();

        if(permisosRolesActual!=null && elPermiso!=null && elRol!=null){
            permisosRolesActual.setId_permiso(elPermiso);
            permisosRolesActual.setId_rol(elRol);
            return this.miRepositorioRolPermiso.save(permisosRolesActual);
        }else{
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{_id}")
    public void delete(@PathVariable String id){
        RolPermiso permisoRolActual = this.miRepositorioRolPermiso
                .findById(id)
                .orElse(null);
        if(permisoRolActual != null){
            this.miRepositorioRolPermiso.delete(permisoRolActual);
        }
    }
}
