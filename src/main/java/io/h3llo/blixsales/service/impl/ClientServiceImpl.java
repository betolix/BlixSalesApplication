package io.h3llo.blixsales.service.impl;

import io.h3llo.blixsales.model.Client;
import io.h3llo.blixsales.repo.IClientRepo;
import io.h3llo.blixsales.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@AllArgsConstructor
 @RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {


    //@Autowired
    //private ClientRepoImpl repo;// = new ClientRepo();

    private final IClientRepo repo;// = new ClientRepo();

    @Override
    public Client save(Client client) throws Exception {
        return repo.save(client);
    }

    @Override
    public Client update(Client client, Integer id) throws Exception {
        return repo.save(client);
    }

    @Override
    public List<Client> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Client readById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Client());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }



    /*public ClientServiceImpl(IClientRepo repo) {
        this.repo = repo;
    }*/

    /*
    @Override
    public Client saveAndValid (Client client){
        if(client.getIdClient() == 0){

            return repo.save(client);
        }else{
            return new Client();
        }
    }*/
}
