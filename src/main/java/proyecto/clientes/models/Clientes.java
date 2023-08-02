package proyecto.clientes.models;

import java.io.Serializable;
// import java.util.Date;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.Temporal;
// import jakarta.persistence.TemporalType;
// import jakarta.persistence.Table;
/**Marcamos esta clase como entity */
@Entity
/**@Table (name="cliente") esto se usa si la tabla de la 
 * base de dato tiene un nombre diferente al de la esta clase
 */
public class Clientes implements Serializable{
   
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    /**Indicamos que el id es incremental y llave 
     * primaria con estos decoradores
     */
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Long edad;

     /**Creamos todos los Getters and Setters*/
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getEdad() {
        return edad;
    }
    public void setEdad(Long edad) {
        this.edad = edad;
    }
    
    
   
   

    
    
    
}
