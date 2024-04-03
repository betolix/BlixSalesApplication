package io.h3llo.blixsales.controller;

import io.h3llo.blixsales.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping
    public Category sayHello(){
        return new Category(1, "COMPUTERS");
    }
}
