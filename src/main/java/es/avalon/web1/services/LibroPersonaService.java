package es.avalon.web1.services;

import org.springframework.beans.factory.annotation.Autowired;

public class LibroPersonaService {
    @Autowired
    private PersonaRepository repoPersona;

    public List<Persona> buscarTodasLasPersonas(){}
}
