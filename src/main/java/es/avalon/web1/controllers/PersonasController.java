package es.avalon.web1.controllers;

import es.avalon.web1.Domain.Persona;
import es.avalon.web1.Services.LibroPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personas")
public class PersonasController {


    @Autowired
    LibroPersonaService servicio;

    @GetMapping("/lista")
    public String lista(Model modelo){
        modelo.addAttribute("lista", servicio.buscarTodasPersonas());
        return "/lista";
    }

    @PostMapping("/nueva")
    public String nueva(Persona persona){
        return "/nueva";
    }

    @PostMapping("/insertar")
    public String insertar(Model modelo, Persona persona){
        servicio.insertarPersona(persona); //insertamos nuevos datos
        modelo.addAttribute( "lista", servicio.buscarTodasPersonas()); //volvemos a cargar la lista cuando terminamos de insertar
        return "/lista";
    }

    @PostMapping("/guardar")
    public String salvar(Model modelo,Persona persona) {

        servicio.guardarPersona(persona);
        modelo.addAttribute("lista", servicio.buscarTodasPersonas());

        return "/lista";

    }
    @GetMapping("/borrar")
    public String borrar(Model modelo, String dni){
        servicio.borrarPersona(new Persona(dni));
        modelo.addAttribute("lista",servicio.buscarTodasPersonas());
        return "/lista";
    }

    @GetMapping("/detalle")
    public String detalle(Model modelo,String dni) {

        Persona persona=servicio.buscarUno(dni);
        modelo.addAttribute("persona", persona);

        return "/detalle";
    }

    @GetMapping("/editar")
    public String editar (Model modelo,String dni) {

        Persona persona=servicio.buscarUno(dni);
        modelo.addAttribute("persona", persona);

        return "/editar";
    }



}

