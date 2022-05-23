package es.avalon.web1.repositories;


import es.avalon.web1.dominio.Persona;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository //Anotacion Spring Framework (SF)
public class PersonaRepository {


    @PersistenceContext //Anotacion Spring Framework (SF)
    EntityManager manager; //Anotacion Spring Framework (SF)


    //Metodo que devuelve todas las personas de la BBDD
    public List<Persona> buscarTodos() {

        //Es una consulta JPA no SQL
        TypedQuery<Persona> consulta = manager.createQuery("select p from Persona p", Persona.class);
        return consulta.getResultList();
    }


    @Transactional ////Anotacion Spring Framework (SF) PODEMOS QUITAR LA TRANSACCION
    public void insertar(Persona p) {
        manager.persist(p);
    }


    @Transactional ////Anotacion Spring Framework (SF) PODEMOS QUITAR LA TRANSACCION
    public void borrar(Persona p) {
        manager.remove(manager.merge(p));
    }


    public Persona buscarUno(String dni) {
        return manager.find(Persona.class, dni);
    }

    //Metodo para actualizar una persona
    @Transactional
    public void salvar(Persona persona) {
        manager.merge(persona);
    }


    public List<Persona> buscarTodosConLibros() {
        //EntityManager manager = JPAHelper.getEntityManager();
        TypedQuery<Persona> consulta = manager.createQuery("select p from Persona p join fetch p.libros", Persona.class);
        List<Persona> list = consulta.getResultList();
        manager.close();
        return list;
    }


    public List<Persona> buscarTodosConLibrosOrdenados(String campo) {
        String texto = "select p from Persona p";

        if (campo.equalsIgnoreCase("dni")) {
            texto += " order by p.dni";
        }

        if (campo.equalsIgnoreCase("nombre")) {
            texto += " order by p.nombre";
        }

        if (campo.equalsIgnoreCase("edad")) {
            texto += " order by p.edad";
        }

        TypedQuery<Persona> consulta = manager.createQuery(texto, Persona.class);
        List<Persona> lista = consulta.getResultList();
        return lista;

    }

}

