package io.h3llo.blixsales.controller;

import io.h3llo.blixsales.model.Client;
import io.h3llo.blixsales.service.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    //@Autowired
    private final IClientService service; // = new ClientService();

    @GetMapping
    public ResponseEntity<List<Client>> readAll() throws Exception{
        List<Client> list = service.readAll();

        return ResponseEntity.ok(list);
        //return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> readById(@PathVariable("id") Integer id) throws Exception{
        Client obj = service.readById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client) throws Exception {
        Client obj = service.save(client);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable("id") Integer id, @RequestBody Client client) throws Exception {
        client.setIdClient(id);
        Client obj = service.update(client, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);

        return ResponseEntity.noContent().build();
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /* public ClientController(IClientService service) {
        this.service = service;
    }*/

    /*
    @GetMapping
    public Client save(){
        // Client client = new Client(0,"TV");
        Client client = new Client();

        return service.saveAndValid(client);
    }
*/

    /*
    @GetMapping
    public Client sayHello(){
        return new Client(1, "COMPUTERS");
    }*/
}
