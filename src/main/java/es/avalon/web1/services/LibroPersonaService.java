package es.avalon.web1.services;


import es.avalon.web1.dominio.Libro;
import es.avalon.web1.dominio.Persona;
import es.avalon.web1.repositories.LibroRepository;
import es.avalon.web1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

public class LibroPersonaService {
    @Autowired
    private LibroRepository repoLibro;
    @Autowired
    private PersonaRepository repoPersona;

    public List<Persona> buscarTodasLasPersonas() {
        return repoPersona.buscaTodos();
    }
    @Transactional
    public void insertarPersona(Persona persona) {

        repoPersona.insertar(persona);
    }
    @Transactional
    public void borrarPersona(Persona persona) {
        repoPersona.borrar(persona);
    }

    public List<Libro> buscarTodosLosLibros() {
        return repoLibro.buscaTodos();
    }
    @Transactional
    public void insertarLibro(Libro libro) {

        repoLibro.insertar(libro);
    }
    @Transactional
    public void borrarLibro(Libro libro) {
        repoLibro.borrar(libro);
    }

    public Persona buscarPersona(String dni) {
        return repoPersona.buscarPersona(dni);

    }

    public Libro buscarLibro(int isbn) {
        return repoLibro.buscarLibro(isbn);
    }

    public int librosPorPersona(String dni) {
        return repoLibro.librosPorPersona(dni);
    }

    public List<Persona> buscarTodosConLibros() {
        return repoPersona.buscarTodosConLibros();
    }
    public void salvarPersona(Persona persona) {
        repoPersona.salvarPersona(persona);
    }
    public void salvarLibro(Libro libro) {
        repoLibro.salvarLibro(libro);
    }
    public List<Persona> buscarTodasLasPersonasOrdenados(String campo) {
        return repoPersona.buscarTodasLasPersonasOrdenados(campo);
    }





}
