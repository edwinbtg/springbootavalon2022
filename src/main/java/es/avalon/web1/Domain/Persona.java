package es.avalon.web1.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Personas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Persona implements Serializable {

    @Id
    private String dni;
    private String nombre;
    private String apellido;
    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private final List<Libro> libros = new ArrayList<>();

    public Persona(String dni){
        this.dni=dni;
    }



}
