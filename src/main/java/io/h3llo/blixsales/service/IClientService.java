package io.h3llo.blixsales.service;

import io.h3llo.blixsales.model.Client;

import java.util.List;

public interface IClientService {
    // public Client saveAndValid(Client client);

    Client save(Client client) throws Exception;

    Client update(Client client, Integer id) throws Exception;

    List<Client> readAll() throws Exception;

    Client readById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;

}
