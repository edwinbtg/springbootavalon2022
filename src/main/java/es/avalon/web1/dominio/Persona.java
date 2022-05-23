package es.avalon.web1.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity //Anotacion de Hibernaty
@Table(name="personas") //La tabla se llama personas, por lo que parcheamos el nombre


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id //Anotacion de Hibernaty para indicar cual es la PrimaryKey, en este caso dni
    private String dni;
    private String nombre;
    private int edad;

    @OneToMany(mappedBy = "persona")
    private final List<Libro> libros = new ArrayList<>();


    public Persona (String dni) {
        this.dni = dni;
    }

    public int ObtenerNumeroDeLibros(){
        return libros.size();
    }

}
