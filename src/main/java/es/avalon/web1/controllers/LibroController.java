package es.avalon.web1.controllers;

import es.avalon.web1.dominio.Libro;
import es.avalon.web1.services.LibroPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    LibroPersonaService servicio;
    @GetMapping("/lista") //  web3/personas/lista
    //En vista.html
    public String lista(Model modelo){
        //pasa a la vista el listado de personas
        modelo.addAttribute("lista", servicio.buscarTodosLosLibros());
        return "libros/lista";
    }

    @PostMapping("/nueva") //nueva pagina  web3/personas/nueva
    //Esto me lleva a la vista para poder insertar
    public String nueva(Libro libro){

        return "libros/nueva";
    }
    @PostMapping("/insertar") //nueva pagina  web3/personas/nueva

    public String insertar(Model modelo,Libro libro){
        servicio.insertarLibro(libro);
        modelo.addAttribute("lista", servicio.buscarTodosLosLibros());
        return "libros/lista";
    }
    @GetMapping("/borrar")

    public String borrar(Model modelo, int isbn){
        servicio.borrarLibro(new Libro(isbn));
        modelo.addAttribute("lista", servicio.buscarTodosLosLibros());
        return "libros/lista";
    }
    @GetMapping("/detalle")

    public String detalle(Model modelo, int isbn){
        Libro libro=servicio.buscarLibro(isbn);
        modelo.addAttribute("libro", libro);
        return "libros/detalle";
    }
    @GetMapping("/editar")

    public String editar(Model modelo, int isbn){
        Libro libro=servicio.buscarLibro(isbn);
        modelo.addAttribute("libro", libro);
        return "libros/editar";
    }
    @PostMapping("/salvar")

    public String salvar(Model modelo,Libro libro){
        servicio.salvarLibro(libro);;
        modelo.addAttribute("lista", servicio.buscarTodosLosLibros());
        return "libros/lista";
    }

}
