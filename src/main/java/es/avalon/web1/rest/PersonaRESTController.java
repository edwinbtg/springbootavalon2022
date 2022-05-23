package es.avalon.web1.rest;

import es.avalon.web1.dominio.Persona;
import es.avalon.web1.services.LibroPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webapi/personas")
public class PersonaRESTController {

    @Autowired
    private LibroPersonaService servicio;
    @GetMapping
    public List<Persona> buscarTodasLasPersonas() {
        return servicio.buscarTodasLasPersonas();
    }
}
