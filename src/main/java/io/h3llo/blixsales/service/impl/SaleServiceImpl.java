package io.h3llo.blixsales.service.impl;

import io.h3llo.blixsales.model.Role;
import io.h3llo.blixsales.repo.IRoleRepo;
import io.h3llo.blixsales.repo.IGenericRepo;
import io.h3llo.blixsales.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
 @RequiredArgsConstructor
public class RoleServiceImpl extends CRUDImpl<Role, Integer> implements IRoleService {


    private final IRoleRepo repo;

    @Override
    protected IGenericRepo<Role, Integer> getRepo() {
        return repo;
    }


}
