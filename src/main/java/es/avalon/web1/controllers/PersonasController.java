package es.avalon.web1.controllers;

import es.avalon.web1.dominio.Persona;
import es.avalon.web1.services.LibroPersonaService;
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
    @GetMapping("/lista") //  web3/personas/lista
    //En vista.html
    public String lista(Model modelo){
        //pasa a la vista el listado de personas
        modelo.addAttribute("lista", servicio.buscarTodasLasPersonas());
        return "personas/lista";
    }

    @PostMapping("/nueva") //nueva pagina  web3/personas/nueva
    //Esto me lleva a la vista para poder insertar
    public String nueva(Persona persona){

        return "personas/nueva";
    }
    @PostMapping("/insertar") //nueva pagina  web3/personas/nueva

    public String insertar(Model modelo,Persona persona){
        servicio.insertarPersona(persona);
        //modelo.addAttribute("lista", servicio.buscarTodasLasPersonas()); ya no hace falta por que en el return indicamos que no redirija a la lista.
        return "redirect:lista";
    }
    @GetMapping("/borrar")

    public String borrar(Model modelo, String dni){
        servicio.borrarPersona(new Persona(dni));
        //modelo.addAttribute("lista", servicio.buscarTodasLasPersonas());
        return "redirect:lista";
    }
    @GetMapping("/detalle")

    public String detalle(Model modelo, String dni){
        Persona persona=servicio.buscarPersona(dni);
        modelo.addAttribute("persona", persona);
        return "personas/detalle";
    }
    @GetMapping("/editar")

    public String editar(Model modelo, String dni){
        Persona persona=servicio.buscarPersona(dni);
        modelo.addAttribute("persona", persona);
        return "personas/editar";
    }
    @PostMapping("/salvar")

    public String salvar(Model modelo, Persona persona){
        servicio.salvarPersona(persona);;
        //modelo.addAttribute("lista", servicio.buscarTodasLasPersonas());
        return "redirect:lista";
    }
    @GetMapping("/orden")
    public String orden(Model modelo, String campo){
        //pasa a la vista el listado de personas
        modelo.addAttribute("lista", servicio.buscarTodasLasPersonasOrdenados(campo));
        return "personas/lista";
    }


}
