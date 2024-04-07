package io.h3llo.blixsales.service;

import io.h3llo.blixsales.model.Category;

public interface ICategoryService {

    public Category saveAndValid(Category category);
}
