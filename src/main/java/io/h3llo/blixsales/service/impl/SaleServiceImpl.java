package io.h3llo.blixsales.service.impl;

import io.h3llo.blixsales.model.Sale;
import io.h3llo.blixsales.repo.IGenericRepo;
import io.h3llo.blixsales.repo.ISaleRepo;
import io.h3llo.blixsales.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
 @RequiredArgsConstructor
public class SaleServiceImpl extends CRUDImpl<Sale, Integer> implements ISaleService {


    private final ISaleRepo repo;

    @Override
    protected IGenericRepo<Sale, Integer> getRepo() {
        return repo;
    }


}
