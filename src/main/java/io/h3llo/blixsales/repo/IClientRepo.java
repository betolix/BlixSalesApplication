package io.h3llo.blixsales.repo;

import io.h3llo.blixsales.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category, Integer> {
    //public Category save(Category category);

}
