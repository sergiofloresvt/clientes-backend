package proyecto.clientes.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.clientes.models.Clientes;
import proyecto.clientes.repositories.ClientesRepository;


/**Usamos esta anotacion para los servicios
 * esto hace que esta clase de un componete ahora del 
 * spring y la marca como un VINS y se registra en el contenedor
 */
@Service
public class ClientesService implements IClientesService{
    /**ClientesService implemeta la interface para */
   
/*Inyectamos la dependecia atraves del Autowired el Clientesrepository */
    @Autowired
    private ClientesRepository clientesRepository;
    @Override
    public List<Clientes> findAll() {
        /**Con el meto findAll usamos el atributo clienteRepository
         * y asi accedemos a los clientes que tengamos en la misma clase
         * Este metodo retorna un iterable por eso convertimos en un list 
         * el retorno
         */
       return (List<Clientes>) clientesRepository.findAll();
    }
    /*Cargamos los metodos para el CRUD */
    @Override
    public Clientes findById(Long id) {
     return clientesRepository.findById(id).orElse(null);   
       
    }
    @Override
    public Clientes save(Clientes clientes) {
        return clientesRepository.save(clientes);
       
    }
    @Override
    public void delete(Long id) {
        clientesRepository.deleteById(id);
        
    }
    
}
