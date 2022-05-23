package es.avalon.web1.controllers;

import es.avalon.web1.Domain.Libro;
import es.avalon.web1.Services.LibroPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/libros")
public class LibrosController {


        @Autowired
        LibroPersonaService servicio;

        @GetMapping("/lista")
        public String lista(Model modelo){
            modelo.addAttribute("lista", servicio.buscarTodosLibros());
            return "/lista";
        }

        @PostMapping("/nueva")
        public String nueva(Libro libro){
            return "/nueva";
        }

        @PostMapping("/insertar")
        public String insertar(Model modelo, Libro libro){
            servicio.insertarLibro(libro); //insertamos nuevos datos
            modelo.addAttribute( "lista", servicio.buscarTodosLibros()); //volvemos a cargar la lista cuando terminamos de insertar
            return "/lista";
        }

        @PostMapping("/guardar")
        public String salvar(Model modelo,Libro libro) {

            servicio.guardarLibro(libro);
            modelo.addAttribute("lista", servicio.buscarTodosLibros());

            return "/lista";

        }
        @GetMapping("/borrar")
        public String borrar(Model modelo, String isbn){
            servicio.borrarLibro(new Libro(isbn));
            modelo.addAttribute("lista",servicio.buscarTodasPersonas());
            return "/lista";
        }

        @GetMapping("/detalle")
        public String detalle(Model modelo,String isbn) {

            Libro libro=servicio.buscarUnoLibro(isbn);
            modelo.addAttribute("libro", libro);

            return "/detalle";
        }

        @GetMapping("/editar")
        public String editar (Model modelo,String isbn) {

            Libro libro=servicio.buscarUnoLibro(isbn);
            modelo.addAttribute("libro", libro);

            return "/editar";
        }

}


