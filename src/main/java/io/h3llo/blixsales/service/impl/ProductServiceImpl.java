package io.h3llo.blixsales.service.impl;

import io.h3llo.blixsales.model.Product;
import io.h3llo.blixsales.repo.IProductRepo;
import io.h3llo.blixsales.repo.IGenericRepo;
import io.h3llo.blixsales.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
 @RequiredArgsConstructor
public class ProductServiceImpl extends CRUDImpl<Product, Integer> implements IProductService {


    private final IProductRepo repo;

    @Override
    protected IGenericRepo<Product, Integer> getRepo() { return repo; }
}
