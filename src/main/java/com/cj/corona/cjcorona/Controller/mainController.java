package com.cj.corona.cjcorona.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class mainController {
    @GetMapping("/hello")
    public String main(Model model){
        return "mainBoard";
    }
}
