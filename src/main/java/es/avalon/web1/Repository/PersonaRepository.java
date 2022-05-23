package es.avalon.web1.Repository;



import es.avalon.web1.Domain.Persona;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PersonaRepository {



        @PersistenceContext
        EntityManager em;

        public List<Persona> buscarTodo(){

            TypedQuery<Persona> consulta= em.createQuery("SELECT p FROM Persona p", Persona.class);
            return consulta.getResultList();

        }
        @Transactional
        public void insertar(Persona p) {
            em.persist(p);
        }
        @Transactional
        public void borrar(Persona pb) {
            em.remove(em.merge(pb));

        }

        public Persona buscarUno(String dni) {

            return em.find(Persona.class,dni);

        }

        @Transactional
        public void guardar(Persona persona) {
            em.merge(persona);
        }

        public List<Persona> buscarTodoConLibros(){
            TypedQuery <Persona> consulta= em.createQuery("SELECT p from Persona p join fetch p.libros", Persona.class);
            List<Persona> lista=consulta.getResultList();
            em.close();
            return lista;


        }
}


