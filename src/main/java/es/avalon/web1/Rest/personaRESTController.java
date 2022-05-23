package es.avalon.web1.Rest;

import es.avalon.web1.Domain.Persona;
import es.avalon.web1.Services.LibroPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webapi/personas")
public class personaRESTController {
    @Autowired
    private LibroPersonaService servicio;

    @GetMapping
    public List<Persona> buscarTodasPersonas(){
        return servicio.buscarTodasPersonas();
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public void insertarPersona(@RequestBody  Persona p) {
        servicio.insertarPersona(p);
    }

}
