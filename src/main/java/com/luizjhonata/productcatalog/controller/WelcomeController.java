package com.luizjhonata.productcatalog.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WelcomeController {

    @Operation(summary = "Message when you access localhost/8080")
    @GetMapping("/")
    public String welcome(Principal principal) {
        String name = principal.getName();
        return "Hello " +name+ "!" + "\r\n Welcome to Product Catalog API!" +
                " \r\n This API was designed to be used by companies that works with sales of connections and pipes of cast iron.";
    }
}
