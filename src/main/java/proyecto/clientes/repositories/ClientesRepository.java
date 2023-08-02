package proyecto.clientes.repositories;

import org.springframework.data.repository.CrudRepository;

import proyecto.clientes.models.Clientes;

 /** En esta interfas indicamos que clase queremos
  * convertir en un repositorio atraves de la extencion CrudRepository
  <Clase , Tipo> 
 */
public interface ClientesRepository extends CrudRepository <Clientes, Long> {
    
}
