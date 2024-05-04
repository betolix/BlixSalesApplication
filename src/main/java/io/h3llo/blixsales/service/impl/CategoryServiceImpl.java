package io.h3llo.blixsales.service.impl;

import io.h3llo.blixsales.model.Category;
import io.h3llo.blixsales.repo.ICategoryRepo;
import io.h3llo.blixsales.repo.IGenericRepo;
import io.h3llo.blixsales.service.ICategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@AllArgsConstructor
 @RequiredArgsConstructor
public class CategoryServiceImpl extends CRUDImpl<Category, Integer> implements ICategoryService {


    //@Autowired
    //private CategoryRepoImpl repo;  // = new CategoryRepo();

    private final ICategoryRepo repo;  // = new CategoryRepo();

    @Override
    protected IGenericRepo<Category, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Category> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Category> findByNameLike(String name) {
        return repo.findByNameLike("%" + name + "%");
    }

    @Override
    public List<Category> findByNameAndEnabled(String name, boolean enabled) {
        return repo.findByNameAndEnabled(name, enabled);
    }

    @Override
    public List<Category> getNameAndDescription1(String name, String description) {
        return repo.getNameAndDescription1(name, description);
    }

    @Override
    public List<Category> getNameAndDescription2(String name, String description) {
        return repo.getNameAndDescription2(name, description);
    }

/*
    @Override
    public Category save(Category category) throws Exception {
        return repo.save(category);
    }

    @Override
    public Category update(Category category, Integer id) throws Exception {
        return repo.save(category);
    }

    @Override
    public List<Category> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Category readById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Category());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }

*/

    /*public CategoryServiceImpl(ICategoryRepo repo) {
        this.repo = repo;
    }*/

    /*
    @Override
    public Category saveAndValid (Category category){
        if(category.getIdCategory() == 0){

            return repo.save(category);
        }else{
            return new Category();
        }
    }*/
}
