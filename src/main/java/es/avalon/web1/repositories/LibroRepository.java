package es.avalon.web1.repositories;


import es.avalon.web1.dominio.Libro;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository

public class LibroRepository {
    @PersistenceContext
    EntityManager em;

    public List<Libro> buscaTodos() {
        TypedQuery<Libro> consulta = em.createQuery("select l from Libro l", Libro.class);
        return consulta.getResultList();

    }

    @Transactional
    public void insertar(Libro l) {
        em.persist(l);
    }
    @Transactional
    public void borrar(Libro l) {
        em.remove(em.merge(l));
    }
    public Libro buscarLibro(int isbn) {
        return em.find(Libro.class, isbn);
    }
    public int librosPorPersona(String dni) {

        TypedQuery<Libro> consulta = em.createQuery("select l from Libro l where personas_dni=dni", Libro.class);
        List<Libro> lista = consulta.getResultList();
        return lista.size();

    }
    @Transactional
    public void salvarLibro(Libro libro){
        em.merge(libro);
    }

}