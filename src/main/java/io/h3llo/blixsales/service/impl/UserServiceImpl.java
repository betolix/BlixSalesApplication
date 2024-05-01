package io.h3llo.blixsales.service.impl;

import io.h3llo.blixsales.model.User;
import io.h3llo.blixsales.repo.IUserRepo;
import io.h3llo.blixsales.repo.IGenericRepo;
import io.h3llo.blixsales.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
 @RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, Integer> implements IUserService {

    private final IUserRepo repo;   

    @Override
    protected IGenericRepo<User, Integer> getRepo() {
        return repo;
    }

    
}
