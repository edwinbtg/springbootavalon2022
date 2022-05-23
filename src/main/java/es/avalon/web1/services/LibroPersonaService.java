package es.avalon.web1.services;

import es.avalon.web1.dominio.Persona;
import es.avalon.web1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Persona> buscarTodosConLibrosOrdenados(String campo) {
        return repoPersona.buscarTodosConLibrosOrdenados(campo);
    }

    // Metodos LIBROS

    //@Autowired

    /*private LibroRepository repoLibro;

    public List<Libro> buscarTodosLosLibros() {

        return repoLibro.buscarTodos();
    }

    public void insertarLibro(Libro libro) {

        repoLibro.insertar(libro);
    }

    public void borrarLibro(Libro libro) {
        repoLibro.borrar(libro);
    }

    public void salvarLibro(Libro libro) {
        repoLibro.salvar(libro);
    }

    public Libro buscarUnlibro(String isbn) {
        return repoLibro.buscarUno(isbn);
    }*/
}
