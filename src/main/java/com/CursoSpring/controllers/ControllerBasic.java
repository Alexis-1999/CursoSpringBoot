package com.CursoSpring.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

import com.CursoSpring.configuration.Pages;
import com.CursoSpring.model.Post;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/home") //Endpoint
public class ControllerBasic {
    
    public List<Post> getPosts(){
        ArrayList<Post> post = new ArrayList<>();

        post.add(new Post(1, "El desarrollo web es un proceso complejo que implica la creación de productos digitales en línea. También es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost:9001/img/perros-cool.jpg", new Date(), "Desarrollo Web"));
        post.add(new Post(2, "El desarrollo web es un proceso complejo que implica la creación de productos digitales en línea. También es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost:9001/img/perros-cool.jpg", new Date(), "Desarrollo Front-End"));
        post.add(new Post(3, "El desarrollo web es un proceso complejo que implica la creación de productos digitales en línea. También es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost:9001/img/perros-cool.jpg", new Date(), "Desarrollo Back-End"));
        post.add(new Post(4, "El desarrollo web es un proceso complejo que implica la creación de productos digitales en línea. También es un término que define la creación de sitios web para Internet o una intranet.", "http://localhost:9001/img/perros-cool.jpg", new Date(), "Desarrollo UX/UI"));
        
        return post;
    }

    @GetMapping(path = {"/posts", "/"})
    public String saludar(Model model){
        model.addAttribute("posts", this.getPosts());
        return "index";
    }

    @GetMapping(path="/public")
    public ModelAndView post() {
        ModelAndView modelAndView = new ModelAndView(Pages.HOME);
        modelAndView.addObject("posts", this.getPosts());
        return modelAndView;
    }

    @GetMapping(path = {"/post"})
    public ModelAndView getPostIndividual(@RequestParam(defaultValue = "1", name="id", required = false) int id) {
       ModelAndView modelAndView = new ModelAndView(Pages.POST);
        
       List<Post> postFiltrado = this.getPosts().stream().filter( (p) -> { //Método Lamba
        return p.getId() == id;
       } ).collect(Collectors.toList());

       modelAndView.addObject("post", postFiltrado.get(0));
       return modelAndView;
    }
    
    
}
