package com.luizjhonata.productcatalog.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to my Product Catalog API! \n" +
                "This API was designed to be used by companies that works with sales of connections and pipes of cast iron.";
    }
}
