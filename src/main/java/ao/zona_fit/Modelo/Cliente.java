package ao.zona_fit.Modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
//Indica que esta clase es una entidad que se va a mapear a
// una tabla de base de datos
@Entity
// Esta anotación de Lombok genera automáticamente métodos como
// getters, setters, equals, hashCode, y toString,
@Data
//Genera un constructor sin argumentos
@NoArgsConstructor
// Se geneera un contructor con todos los argumentos
@AllArgsConstructor
//agregar el metodo toString;
@ToString

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    // se usa en la clase objeto para que de un valor nulo
    private Integer menbresia;



}
