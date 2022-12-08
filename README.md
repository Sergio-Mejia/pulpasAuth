# BACKEND DE SEGURIDAD
### Java Spring Boot

Base de datos para la administración de usuarios, administración de
roles y administración de los permisos de cada usuario dentro del
aplicativo web


### Administración Usuarios
* **GET** 
  * ``server/usuarios``: Mostrar usuarios registrados con sus respectivos datos
  * ``server/usuarios/{cedula}``: Mostrar datos de un usuario en específico
* **POST**
  * ``server/usuarios``: Registrar usuario en la base de datos. Son necesarios los siguientes campos dentro de un JSON
    * cedula 
    * user 
    * password 
    * nombres 
    * apellidos 
    * ciudad 
    * direccion
* **PUT**
  * ``server/usuarios/{cedula}``: Actualizar los datos del usuario con la cédula solicitada. Los datos se envian a traves de un JSON
      * user
      * password
      * nombres
      * apellidos
      * ciudad
      * direccion
* **DELETE**:
  * ``server/usuarios/{cedula}``: Eliminar usuario según su cedula


### Administración Permisos
* **GET**
  * ``server/permiso``: Mostrar permisos a los que pueden acceder los usuarios
  * ``server/permiso/{id}``: Mostrar informacion de un permiso en específico
* **POST**
  * ``server/permiso``: Registrar permiso en la base de datos. Son necesarios los siguientes campos dentro de un JSON
    * url
    * metodo
* **PUT**
  * ``server/permiso/{id}``: Actualizar los datos del permiso con el Id solicitado. Los datos se envían a traves de un JSON
    * url
    * metodo
* **DELETE**:
  * ``server/permiso/{id}``: Eliminar permiso por su identificador

### Administración Roles
* **GET**
  * ``server/rol``: Mostrar roles del sistema
  * ``server/rol/{id}``: Mostrar informacion de un rol en específico
* **POST**
  * ``server/rol``: Registrar rol en la base de datos. Son necesarios los siguientes campos dentro de un JSON
    * nombre
    * descripcion
* **PUT**
  * ``server/rol/{id}``: Actualizar los datos del rol con el Id solicitado. Los datos se envían a traves de un JSON
    * nombre
    * descripcion
* **DELETE**:
  * ``server/rol/{id}``: Eliminar rol por su identificador

### Administración Rol/Permiso
_Tabla intermedia entre roles y permisos, donde se asigna uno o varios roles a uno o varios permisos._ 
* **GET**
  * ``server/rolpermiso``: Mostrar todos los permisos asignados a los diferentes roles
  * ``server/rolpermiso/{id}``: Mostrar informacion de un rolpermiso 
* **POST**
  * ``server/rolpermiso/rol/{id_rol}/permiso/{id_permiso}``: Asignar permiso a un rol. Los datos son enviados en la URL
* **PUT**
  * ``server/rolpermiso/{id_rolPermiso}/rol/{id_rol}/permiso/{id_permiso}``: Actualizar los parametros del rolpermiso creado
* **DELETE**:
  * ``server/rolpermiso/{id}``: Eliminar rolPermiso por su identificador