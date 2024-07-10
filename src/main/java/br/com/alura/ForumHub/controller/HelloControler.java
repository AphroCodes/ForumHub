package br.com.alura.ForumHub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forum")
public class HelloControler {

    @GetMapping
    public String abrirForum() {
        return "Hello World";
    }
}
