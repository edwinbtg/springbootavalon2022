package es.avalon.web1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personas")
public class HolaController {
    @GetMapping("/hola")
    public String  hola() {

        return "hola";

    }
}
