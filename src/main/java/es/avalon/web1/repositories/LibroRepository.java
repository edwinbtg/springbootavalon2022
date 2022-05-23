package es.avalon.web1.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import es.avalon.web1.dominio.Libro;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository //Anotacion Spring Framework (SF)
public class LibroRepository {


    @PersistenceContext //Anotacion Spring Framework (SF)
    EntityManager manager; //Anotacion Spring Framework (SF)

    //Metodo que devuelve todas las personas de la BBDD
    public List<Libro> buscarTodos() {

        //EntityManager manager = JPAHelper.getEntityManager();
        TypedQuery<Libro> consulta = manager.createQuery("select l from Libro l", Libro.class);
        return consulta.getResultList();
    }

    @Transactional ////Anotacion Spring Framework (SF) PODEMOS QUITAR LA TRANSACCION
    public void insertar(Libro l) {

        //EntityManager manager = JPAHelper.getEntityManager();

        //manager.getTransaction().begin();
        manager.persist(l);
        //manager.getTransaction().commit();
    }

    @Transactional ////Anotacion Spring Framework (SF) PODEMOS QUITAR LA TRANSACCION
    public void borrar(Libro l) {

        //EntityManager manager = JPAHelper.getEntityManager();

        //manager.getTransaction().begin();
        manager.remove(manager.merge(l));
        //manager.getTransaction().commit();

    }

    public Libro buscarUno(String isbn) {

        //EntityManager manager = JPAHelper.getEntityManager();

        return manager.find(Libro.class, isbn);
    }


    //Metodo para actualizar un libro
    @Transactional
    public void salvar(Libro libro) {
        manager.merge(libro);
    }

    /*public void actualizar(Libro l) {
        EntityManager manager = JPAHelper.getEntityManager();

        manager.getTransaction().begin();
        manager.merge(l);
        manager.getTransaction().commit();
    }*/
}
