package es.avalon.web1.controllers;

import es.avalon.web1.dominio.Persona;
import es.avalon.web1.services.LibroPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //(SF)
@RequestMapping("/personas") //Se añadira a la url /personas (No tiene que ver con nuestra carpeta personas pero clarifica, podriamos poner lo que quisieramos)
public class PersonasController {


    //DEFINIMOS CONTROLADOR Y ACCION DE LISTADO
    @Autowired
    LibroPersonaService servicio;



    //***METODOS DE LISTADO, INSERCCION, CREACION, MOFIFICACION Y BORRADO***/
    @GetMapping("/lista")
    public String lista(Model modelo) { //Objeto Model se utiliza para cargar datos que van a ir a la vista

        //Pasamos a la vista ("lista"), el listado de personas
        modelo.addAttribute("lista", servicio.buscarTodasLasPersonas());

        //Retornamos la pagina HTML llamada lista, que se encuentra en la carpeta personas
        return "personas/lista";
    }

    @GetMapping("/lista/orden")
    public String listaOrdenada(Model modelo, String campo) { //Objeto Model se utiliza para cargar datos que van a ir a la vista

        //Pasamos a la vista ("lista"), el listado de personas
        modelo.addAttribute("lista", servicio.buscarTodosConLibrosOrdenados(campo));

        //Retornamos la pagina HTML llamada lista, que se encuentra en la carpeta personas
        return "personas/lista";
    }


    @PostMapping("/nueva") //Definimos un POST ya que venimos de un Form(method="POST") con (action="nueva")
    public String nueva(Persona persona) {
        //Retornamos pagina de nueva para ingresar una persona
        return "personas/nueva";
    }


    @PostMapping("/insertar")
    public String insertar (Model modelo, Persona persona){

        //Llamamos al servicio para que ingrese la persona
        servicio.insertarPersona(persona);
        return "redirect:lista";
    }


    @GetMapping("/borrar")
    public String borrar (Model modelo, String dni){
        //Llamamos al servicio para que borre la persona
        servicio.borrarPersona(new Persona(dni));

        return "redirect:lista";
    }


    @GetMapping("/detalle")
    public String detalle (Model modelo, String dni){

        //Llamamos al servicio para que cargue una persona a partir del dni
        Persona persona = servicio.buscarUnaPersona(dni);

        //Acudimos al modelo para que pase los datos de la persona con el codigo "persona" que recogeremos en la vista */detalle, a la que nos redigiremos
        modelo.addAttribute("persona", persona);
        return "personas/detalle";
    }


    //Vamos a recoger los datos de la persona a traves de su DNI y vamos a redirigirnos con ellos al documento */editar
    @GetMapping("/editar")
    public String editar (Model modelo, String dni){
        Persona persona = servicio.buscarUnaPersona(dni);
        modelo.addAttribute("persona", persona);
        return "personas/editar";
    }


    //Actualizar datos
    @PostMapping("/salvar")
    public String salvar (Model modelo, Persona persona){
        //Llamamos al servicio para que actualice la persona
        servicio.salvarPersona(persona);

        //Nos redirige a lista
        return "redirect:lista";
    }

}
