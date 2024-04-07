package io.h3llo.blixsales.service;

import io.h3llo.blixsales.model.Category;
import io.h3llo.blixsales.repo.ICategoryRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
 @RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {


    //@Autowired
    //private CategoryRepoImpl repo;// = new CategoryRepo();
    private final ICategoryRepo repo;// = new CategoryRepo();


    /*public CategoryServiceImpl(ICategoryRepo repo) {
        this.repo = repo;
    }*/

    @Override
    public Category saveAndValid (Category category){
        if(category.getIdCategory() == 0){

            return repo.save(category);
        }else{
            return new Category();
        }
    }
}
