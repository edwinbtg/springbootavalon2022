package es.avalon.web1.dominio;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="libros")
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Libro {
    @Id
    private String isbn;
    private String titulo;
    private String autor;

    /*@ManyToOne
    @JoinColumn(name="personas_Dni")
    private Persona persona;*/

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Libro(String isbn) {
        this.isbn = isbn;
    }



}
