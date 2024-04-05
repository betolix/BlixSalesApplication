package io.h3llo.blixsales.repo;

import io.h3llo.blixsales.model.Category;
import org.springframework.stereotype.Repository;


@Repository
public class CategoryRepoImpl implements ICategoryRepo{

    @Override
    public Category save(Category category) {
        System.out.println("Saving....");
        return category;
    }
}
