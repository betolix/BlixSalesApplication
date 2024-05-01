package io.h3llo.blixsales.service.impl;

import io.h3llo.blixsales.model.Provider;
import io.h3llo.blixsales.repo.IProviderRepo;
import io.h3llo.blixsales.repo.IGenericRepo;
import io.h3llo.blixsales.service.IProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
 @RequiredArgsConstructor
public class ProviderServiceImpl extends CRUDImpl<Provider, Integer> implements IProviderService {

    private final IProviderRepo repo;

    @Override
    protected IGenericRepo<Provider, Integer> getRepo() {
        return repo;
    }


}
