package es.avalon.web1.rest;

import es.avalon.web1.dominio.Persona;
import es.avalon.web1.services.LibroPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("*webapi/personas")
public class PersonaRESTController {

@Autowired
    private LibroPersonaService servicio;
@GetMapping
    public List<Persona> buscarTodos() {return servicio.buscarTodasLasPersonas();}

    @PostMapping ( consumes = MediaType.APPLICATION_JSON_VALUE )
    public void insertar(@RequestBody Persona p) {
        servicio.insertarPersona(p);
    }

}
