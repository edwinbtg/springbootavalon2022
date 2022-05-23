package es.avalon.web1.repositories;

import es.avalon.web1.dominio.Libro;
import es.avalon.web1.dominio.Persona;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository

public class PersonaRepository {
    @PersistenceContext
    EntityManager em;

    public List<Persona> buscaTodos() {

        // no es una consulta de SQL, es una consulta de JPA QL
        TypedQuery<Persona> consulta = em.createQuery("select p from Persona p", Persona.class);
        return consulta.getResultList();
    }

    @Transactional
    public void insertar(Persona p) {
        em.persist(p);
    }

    @Transactional
    public void borrar(Persona p) {
        em.remove(em.merge(p));
    }

    public Persona buscarPersona(String dni) {
        return em.find(Persona.class, dni);
    }

    public List<Persona> buscarTodosConLibros() {
        TypedQuery<Persona> consulta = em.createQuery("select p from Persona p join fetch p.libros", Persona.class);
        List<Persona> lista = consulta.getResultList();
        em.close();
        return lista;
    }

    public Persona buscarPersonaPorLibro(Libro l) {
        TypedQuery<Libro> consulta = em.createQuery("select l from Libro l join fetch l.personas_dni", Libro.class);
        List<Libro> lista = consulta.getResultList();
        // List<Persona>personas
        return (Persona) lista;
    }
    @Transactional
    public void salvarPersona(Persona persona){
        em.merge(persona);
    }
    public List<Persona> buscarTodasLasPersonasOrdenados(String campo) {
        String texto="select p from Persona p ";
        if (campo.equalsIgnoreCase("nombre")){
            texto+= " order by p.nombre" ;
        }
        if (campo.equalsIgnoreCase("apellidos")){
            texto+= " order by p.apellidos" ;

        }if (campo.equalsIgnoreCase("dni")){
            texto+= "order by p.dni" ;
        }
        TypedQuery <Persona> consulta=
                em.createQuery(texto, Persona.class);
        System.out.println(texto);
        List<Persona> lista=consulta.getResultList();
        return lista;

    }



}
