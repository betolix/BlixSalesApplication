package io.h3llo.blixsales.service;

import io.h3llo.blixsales.model.Category;

import java.util.List;

public interface ICategoryService extends ICRUD<Category, Integer> {

    /*
    Category save(Category category) throws Exception;
    Category update(Category category, Integer id) throws Exception;
    List<Category> readAll() throws Exception;
    Category readById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
*/

    // public Category saveAndValid(Category category);

    List<Category> findByName(String name);

    List<Category> findByNameLike(String name);

    List<Category> findByNameAndEnabled(String name, boolean enabled);


}
