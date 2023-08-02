package proyecto.clientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import proyecto.clientes.models.Clientes;
import proyecto.clientes.service.IClientesService;

@CrossOrigin(origins = { "http://localhost:4200" })
/*
 * Esta anotacion habilita el acceso a recursos (endpoints) desde diferentes 
 * orígenes o dominios en una aplicación web. En este caso la 
 * ruta elegida es el puerto 4200 de angular
 */
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private IClientesService clientesService;

    @GetMapping("/usuarios")
   
    public List<Clientes> index() {
        return clientesService.findAll();
/*
 * El controlador tiene una dependencia inyectada IClientesService mediante la
 * anotación @Autowired. Esta dependencia se utiliza para acceder a los métodos
 * de servicio relacionados con la entidad "Clientes".
 * 
 * El método index() es el punto de entrada para la solicitud HTTP GET en la
 * ruta "/api". Este método llama al método findAll() del servicio de clientes
 * para obtener una lista de todos los clientes. La lista de clientes se
 * devuelve como respuesta HTTP.
 */
    }
    /*Implementamos el metodo buscar por id */
    @GetMapping("/usuarios/{id}")
    public Clientes show(@PathVariable long id){
    /*Esto va retornar el cliente convertido a JSON
    y le pasamos path id */    
        return clientesService.findById(id);
    }
    /*Metodo para crear un cliente */
    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    /*Cada vez que carguemos un nueno cliente 
     * nos arroja un codigo 201 de creacion
     */
    public Clientes create(@RequestBody Clientes clientes){
        return clientesService.save(clientes);
    }
    /*Metodo para actuliazar un atributo de un cliente */
    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes update(@RequestBody Clientes clientes, @PathVariable Long id){
        Clientes clienteActual = clientesService.findById(id);

        clienteActual.setNombre(clientes.getApellido());
        clienteActual.setNombre(clientes.getNombre());
        clienteActual.setEmail(clientes.getEmail());

        return clientesService.save(clienteActual);

    }
    /*Metodo para eliminar por id */
    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /*Cargamos uns respuesta 204 que es sin contenido */
    public void delete(@PathVariable Long id){
        clientesService.delete(id);
    } 

}
