package io.h3llo.blixsales.service;

import io.h3llo.blixsales.model.Category;
import io.h3llo.blixsales.repo.CategoryRepoImpl;
import io.h3llo.blixsales.repo.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {


    @Autowired
    //private CategoryRepoImpl repo;// = new CategoryRepo();
    private ICategoryRepo repo;// = new CategoryRepo();

    public Category saveAndValid (Category category){
        if(category.getIdCategory() == 0){

            return repo.save(category);
        }else{
            return new Category();
        }
    }
}
