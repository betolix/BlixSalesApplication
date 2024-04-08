package io.h3llo.blixsales.controller;

import io.h3llo.blixsales.model.Category;
import io.h3llo.blixsales.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    //@Autowired
    private final ICategoryService service; // = new CategoryService();

    @GetMapping
    public List<Category> readAll() throws Exception{
        return service.readAll();
    }

    @GetMapping("/{id}")
    public Category readById(@PathVariable("id") Integer id) throws Exception{
        return service.readById(id);
    }

    @PostMapping
    public Category save(@RequestBody Category category) throws Exception {
        return service.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable("id") Integer id, @RequestBody Category category) throws Exception {
        category.setIdCategory(id);
        return service.update(category, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }

    /* public CategoryController(ICategoryService service) {
        this.service = service;
    }*/

    /*
    @GetMapping
    public Category save(){
        // Category category = new Category(0,"TV");
        Category category = new Category();

        return service.saveAndValid(category);
    }
*/

    /*
    @GetMapping
    public Category sayHello(){
        return new Category(1, "COMPUTERS");
    }*/
}
