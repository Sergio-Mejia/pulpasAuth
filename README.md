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