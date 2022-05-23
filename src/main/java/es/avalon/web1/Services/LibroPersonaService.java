package es.avalon.web1.Services;

import es.avalon.web1.Domain.Libro;
import es.avalon.web1.Domain.Persona;
import es.avalon.web1.Repository.LibroRepository;
import es.avalon.web1.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroPersonaService {

    @Autowired
    private LibroRepository libroRepo;
    @Autowired
    private PersonaRepository repoPersona;

    public List<Persona> buscarTodasPersonas(){

        return repoPersona.buscarTodo();
    }

    public void insertarPersona (Persona persona){

        repoPersona.insertar(persona);
    }

    public void borrarPersona (Persona persona){

        repoPersona.borrar(persona);
    }

    public Persona buscarUno (String dni){

        return repoPersona.buscarUno(dni);
    }

    public void guardarPersona(Persona persona) {
        repoPersona.guardar(persona);
    }

    // ******************************************************* LIBROS **************************************//

    public List<Libro> buscarTodosLibros(){

        return libroRepo.buscarTodo();
    }

    public void insertarLibro (Libro libro){

        libroRepo.insertar(libro);
    }

    public void borrarLibro (Libro libro){

        libroRepo.borrar(libro);
    }

    public Libro buscarUnoLibro (String isbn){

        return libroRepo.buscarUnoLibro(isbn);
    }

    public void guardarLibro(Libro libro) {
        libroRepo.guardarLibro(libro);
    }

    public List<Persona> buscarTodoConLibros(){
        return repoPersona.buscarTodoConLibros();
    }

}

