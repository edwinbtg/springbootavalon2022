package es.avalon.web1.Repository;

import es.avalon.web1.Domain.Libro;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class LibroRepository {



        @PersistenceContext
        EntityManager em;

        public List<Libro> buscarTodo(){
            TypedQuery<Libro> consulta= em.createQuery("SELECT l FROM Libro l", Libro.class);
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

        public Libro buscarUnoLibro(String isbn) {

            return em.find(Libro.class,isbn);

        }

        @Transactional
        public void guardarLibro(Libro l) {
            em.merge(l);
        }

}


