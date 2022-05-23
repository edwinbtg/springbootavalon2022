package es.avalon.web1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.avalon.web1.dominio.Libro;
import es.avalon.web1.dominio.Persona;
import es.avalon.web1.repositories.PersonaRepository;

import java.util.List;

@Service

public class LibroPersonaService {
    @Autowired
    private PersonaRepository repoPersona;

    public List<Persona> buscarTodasLasPersonas() {

        return repoPersona.buscarTodos();
    }

    public void insertarPersona(Persona persona) {

        repoPersona.insertar(persona);
    }

    public void borrarPersona(Persona persona) {


        repoPersona.borrar(persona);
    }

    public Persona buscarUnaPersona(String dni) {
        return repoPersona.buscarUno(dni);

    }


    public List<Persona> buscarTodosConLibros() {
        return repoPersona.buscarTodosConLibros();
    }

    public void salvarPersona(Persona persona) {
        repoPersona.salvar(persona);
    }
    /*
    //metodos de libros

    @Autowired
    private LibroRepository repoLibro;

    public List<Libro> buscarTodosLosLibros() {

        return repoLibro.buscarTodos();
    }

    public void insertarlibros(Libro libro) {

        repoLibro.insertar(libro);
    }

    public void borrarlibros(Libro libro) {


        repoLibro.borrar(libro);
    }

    public Libro buscarUnlibro(String isbn) {
        return repoLibro.buscarUno(isbn);
    }

    public void salvarLibros(Libro libro) {
        repoLibro.salvar(libro);
    }

    public List<Persona> buscarTodosConLibrosOrdenados(String campo) {
        return repoPersona.buscarTodosConLibrosOrdenados(campo);
    }

*/

}
