package io.h3llo.blixsales.controller;

import io.h3llo.blixsales.model.Category;
import io.h3llo.blixsales.service.CategoryServiceImpl;
import io.h3llo.blixsales.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    //@Autowired
    private ICategoryService service; // = new CategoryService();

    /* public CategoryController(ICategoryService service) {
        this.service = service;
    }*/

    @GetMapping
    public Category save(){
        // Category category = new Category(0,"TV");
        Category category = new Category();

        return service.saveAndValid(category);
    }


    /*
    @GetMapping
    public Category sayHello(){
        return new Category(1, "COMPUTERS");
    }*/
}
