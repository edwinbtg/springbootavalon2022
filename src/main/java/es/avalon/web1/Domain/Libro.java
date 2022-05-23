package es.avalon.web1.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name="Libros")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Libro {

    @Id
    private String ISBN;
    private String Titulo;
    private String Autor;


    @ManyToOne
    @JoinColumn(name = "personas_dni")
    private Persona persona;


    public Libro(String iSBN) {
        ISBN = iSBN;
    }


    public Libro(String iSBN, String titulo, String autor) {
        ISBN = iSBN;
        Titulo = titulo;
        Autor = autor;
    }
}