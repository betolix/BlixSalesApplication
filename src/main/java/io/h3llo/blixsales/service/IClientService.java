package io.h3llo.blixsales.service;

import io.h3llo.blixsales.model.Category;

import java.util.List;

public interface ICategoryService {
    // public Category saveAndValid(Category category);

    Category save(Category category) throws Exception;

    Category update(Category category, Integer id) throws Exception;

    List<Category> readAll() throws Exception;

    Category readById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;

}
