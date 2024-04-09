package io.h3llo.blixsales.controller;

import io.h3llo.blixsales.model.Category;
import io.h3llo.blixsales.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    //@Autowired
    private final ICategoryService service; // = new CategoryService();

    @GetMapping
    public ResponseEntity<List<Category>> readAll() throws Exception{
        List<Category> list = service.readAll();

        return ResponseEntity.ok(list);
        //return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> readById(@PathVariable("id") Integer id) throws Exception{
        Category obj = service.readById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category) throws Exception {
        Category obj = service.save(category);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") Integer id, @RequestBody Category category) throws Exception {
        category.setIdCategory(id);
        Category obj = service.update(category, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        return ResponseEntity.noContent().build();
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
