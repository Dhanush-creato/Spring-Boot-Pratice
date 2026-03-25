package org.springexmaples.BankingApi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class Banking {

    @GetMapping
    public BankingGetterandSetter sayHello(){
        return new BankingGetterandSetter("Hello Welcome to Banking API");
    }
    @GetMapping("/{name}")
    public BankingGetterandSetter sayHello(@PathVariable String name){
        return new BankingGetterandSetter("Hello " + name +"! Welcome to Banking API");
    }
    @PostMapping
    public BankingGetterandSetter greetUser(@RequestBody String name){
        return new BankingGetterandSetter("Hello "+name +"! Welcome come to Banking API");
    }
}
