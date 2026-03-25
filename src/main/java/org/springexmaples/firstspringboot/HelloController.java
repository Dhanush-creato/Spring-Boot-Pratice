package org.springexmaples.firstspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello/{name}")
    public String Hello(@PathVariable String name){   // it will print in normal way with path variable

        return "Hello " + name;
    }




    @GetMapping("/hello")
    public  HelloProgramWithGetterAndSetter Hello(){  //used for geter and setter to get in json formate

        return new HelloProgramWithGetterAndSetter("Hello World");
    }

    @PostMapping("/hello")                //By using Getter And Setter it Will give in Json Formate
    public HelloProgramWithGetterAndSetter HelloPost(@RequestBody String name){
        return new HelloProgramWithGetterAndSetter("Hello"+ name + " !");
    }
}
