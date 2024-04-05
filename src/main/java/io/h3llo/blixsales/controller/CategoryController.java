package io.h3llo.blixsales.controller;

import io.h3llo.blixsales.model.Category;
import io.h3llo.blixsales.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService service; // = new CategoryService();

    @GetMapping
    public Category save(){
        Category category = new Category(0,"TV");

        return service.saveAndValid(category);
    }


    /*
    @GetMapping
    public Category sayHello(){
        return new Category(1, "COMPUTERS");
    }*/
}
