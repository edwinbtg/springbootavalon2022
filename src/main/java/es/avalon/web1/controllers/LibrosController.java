package es.avalon.web1.controllers;

import es.avalon.web1.dominio.Libro;
import es.avalon.web1.services.LibroPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //(SF)
@RequestMapping("/libros")
public class LibrosController {


    //DEFINIMOS CONTROLADOR Y ACCION DE LISTADO
    @Autowired
    LibroPersonaService servicio;


    @GetMapping("/lista")
    public String lista(Model modelo) { //Objeto Model se utiliza para cargar datos que van a ir a la vista

        //Pasamos a la vista ("lista"), el listado de personas
        modelo.addAttribute("lista", servicio.buscarTodosLosLibros());

        //Retornamos la pagina HTML llamada lista, que se encuentra en la carpeta personas
        return "libros/lista";
    }


    @PostMapping("/nueva") //Definimos un POST ya que venimos de un Form(method="POST") con (action="nueva")
    public String nueva(Libro libro) {
        //Retornamos pagina de nueva para ingresar una persona
        return "libros/nueva";
    }


    @PostMapping("/insertar")
    public String insertar(Model modelo, Libro libro) {

        //Llamamos al servicio para que ingrese la persona
        servicio.insertarLibro(libro);

        //Retornamos a la vista lista cargando y pasando nuevamente el listado (ahora actualizado)
        modelo.addAttribute("lista", servicio.buscarTodosLosLibros());

        return "libros/lista";
    }


    @GetMapping("/borrar")
    public String borrar(Model modelo, String isbn) {

        //Llamamos al servicio para que borre la persona
        servicio.borrarLibro(new Libro(isbn));

        //Volvemos a cargar lista
        modelo.addAttribute("lista", servicio.buscarTodosLosLibros());
        return "libros/lista";
    }


    @GetMapping("/detalle")
    public String detalle(Model modelo, String isbn) {

        //Llamamos al servicio para que cargue una persona a partir del dni
        Libro libro = servicio.buscarUnLibro(isbn);

        //Acudimos al modelo para que pase los datos de la persona con el codigo "persona" que recogeremos en la vista *//*detalle, a la que nos redigiremos
        modelo.addAttribute("libro", libro);
        return "libros/detalle";
    }


    //Vamos a recoger los datos de la persona a traves de su DNI y vamos a redirigirnos con ellos al documento */editar
    @GetMapping("/editar")
    public String editar(Model modelo, String isbn) {
        Libro libro = servicio.buscarUnLibro(isbn);
        modelo.addAttribute("libro", libro);

        return "libros/editar";
    }


    @PostMapping("/salvar")
    public String salvar(Model modelo, Libro libro) {

        //Llamamos al servicio para que actualice la persona
        servicio.salvarLibro(libro);

        //Retornamos a la vista lista cargando y pasando nuevamente el listado (ahora actualizado)
        modelo.addAttribute("lista", servicio.buscarTodosLosLibros());

        return "libros/lista";
    }

}

