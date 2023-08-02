package proyecto.clientes.service;

import java.util.List;



import proyecto.clientes.models.Clientes;



public interface IClientesService {
    /* CRUD */
   
    public List<Clientes> findAll();
    /**Creamos los metodos del contrato crud */
    public Clientes findById(Long id);

    public Clientes save(Clientes clientes);
    
    public void delete(Long id);
}
