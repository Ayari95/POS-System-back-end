package org.pfe.tn.Controllers;

import org.pfe.tn.Services.IClientService;
import org.pfe.tn.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientController {

    @Autowired
    IClientService iClientService;

    @GetMapping
    public List<Client> getAll(){
        return iClientService.retrieveAllClients();

    }
    @GetMapping("{idClient}")

    public Optional<Client> retrieveInscription(@PathVariable Long idClient) {

        return  iClientService.retrieveClient(idClient);

    }
    @PostMapping

    public Client addClient(@RequestBody Client client){

        return iClientService.addClient(client);
    }
    @DeleteMapping("{idClient}")
    public void removeClient(@PathVariable Long idClient){

        iClientService.removeClient(idClient);
    }

    @PutMapping
    public Client updateClient(@RequestBody Client client) {

        return  iClientService.updateClient(client);

    }

}
