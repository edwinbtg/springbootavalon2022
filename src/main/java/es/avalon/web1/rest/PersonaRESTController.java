package es.avalon.web1.rest;


import es.avalon.web1.dominio.Persona;
import es.avalon.web1.services.LibroPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

//Anotacion SF
@RestController
@RequestMapping("/webapi/personas") //Le pasamos ruta donde nos devolvera los datos en formato JSON
public class PersonaRESTController {

    @Autowired
    private LibroPersonaService servicio;

    @GetMapping
    public List<Persona> buscarTodasLasPersonas() {
        return servicio.buscarTodasLasPersonas();
    }

    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertar(@RequestBody Persona p){
        servicio.insertarPersona(p);
    }
}
