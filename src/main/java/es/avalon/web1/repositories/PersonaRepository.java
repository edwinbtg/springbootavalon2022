package es.avalon.web1.repositories;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import es.avalon.web1.dominio.Persona;


@Repository
public class PersonaRepository {

    @PersistenceContext
    EntityManager em;

    public List<Persona> buscarTodos() {

        TypedQuery<Persona> consulta=em.createQuery("select p from Persona p",Persona.class);
        return consulta.getResultList();

    }

    public Persona buscarUno(String dni) {
        return em.find(Persona.class,dni);

    }

    @Transactional
    public void insertar(Persona p) {

        em.persist(p);
    }
    @Transactional
    public void borrar(Persona persona) {

        em.remove(em.merge(persona));
    }
    @Transactional
    public void salvar(Persona persona) {
        em.merge(persona);
    }


    public List<Persona> buscarTodosConLibros() {

        TypedQuery<Persona> consulta = em.createQuery("select p from Persona p join fetch p.libros", Persona.class);
        List<Persona> lista=consulta.getResultList();
        em.close();
        return lista;

    }

    public List<Persona> buscarTodosConLibrosOrdenados(String campo) {
        String texto= "select p from Persona p";
        if (campo.equalsIgnoreCase("nombre")){
            texto+=" order by p.nombre";
        }

        if (campo.equalsIgnoreCase("edad")){
            texto+=" order by p.edad";
        }
        if (campo.equalsIgnoreCase("dni")){
            texto+=" order by p.dni";
        }

        TypedQuery<Persona> consulta =
                em.createQuery(texto, Persona.class);
        List<Persona> lista=consulta.getResultList();
        return lista;

    }

}
