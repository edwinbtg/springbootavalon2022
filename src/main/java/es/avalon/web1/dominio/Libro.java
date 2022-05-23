package es.avalon.web1.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity //Anotacion de Hibernate para indicar que es una entidad comprendida en una tabla
@Table(name="libros") //La tabla se llama libros, por lo que parcheamos el nombre

//Uso de Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id
    private String isbn;
    private String titulo;
    private String autor;

    @ManyToOne //Anotacion de JPA Hibernate para indicar la relacion con otra tabla
    @JoinColumn(name = "personas_dni")
    //Anotacion de Hibernate donde indicamos el nombre del campo con el que tiene relacion
    private Persona persona; //Por la relacion con libros a traves del campo en la tabla libros de "personas_dni"


    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }


    public Libro(String isbn) {
        this.isbn = isbn;
    }

}