package es.avalon.web1.services;


import es.avalon.web1.dominio.Libro;
import es.avalon.web1.dominio.Persona;
import es.avalon.web1.repositories.LibroRepository;
import es.avalon.web1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //ANOTACION SPRING FRAMEWORK (SF)
public class LibroPersonaService {



    //Instanciamos los repositorios de ambos objetos
    //private LibroRepository repoLibro = new LibroRepository();
    //private PersonaRepository repoPersona = new PersonaRepository();



    @Autowired  //ANOTACION SPRING FRAMEWORK para que GENERE LA DEPENDENCIA (SF)
    private LibroRepository repoLibro; //no hace falta inicializarle (SF)

    @Autowired  //ANOTACION SPRING FRAMEWORK para que GENERE LA DEPENDENCIA (SF)
    private PersonaRepository repoPersona; //no hace falta inicializarle (SF)



    //Creamos los metodos ya creados del repositorio
    public List<Persona> buscarTodasLasPersonas(){
        return repoPersona.buscarTodos();
    }

    public List<Persona> buscarTodasLasPersonasConLibros(){
        return repoPersona.buscarTodosConLibros();
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

    public void salvarPersona(Persona persona) {
        repoPersona.salvar(persona);
    }

    public List<Persona> buscarTodosConLibrosOrdenados(String campo) {
        return repoPersona.buscarTodosConLibrosOrdenados(campo);
    }



    //Creamos los metodos ya creados del repositorio
    public List<Libro> buscarTodosLosLibros(){
        return repoLibro.buscarTodos();
    }

    public void insertarLibro(Libro libro) {
        repoLibro.insertar(libro);
    }

    public void borrarLibro(Libro libro) {
        repoLibro.borrar(libro);
    }

    public void actualizarLibro(Libro libro){
        //repoLibro.actualizar(libro);
    }

    public Libro buscarUnLibro(String isbn) {
        return repoLibro.buscarUno(isbn);
    }

    public void salvarLibro(Libro libro) {
        repoLibro.salvar(libro);
    }





}
