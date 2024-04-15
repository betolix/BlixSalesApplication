package io.h3llo.blixsales.repo;

import io.h3llo.blixsales.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepo extends JpaRepository<Client, Integer> {
    //public Client save(Client category);

}
