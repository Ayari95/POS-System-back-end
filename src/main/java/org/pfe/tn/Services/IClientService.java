package org.pfe.tn.Services;

import org.pfe.tn.entities.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    List<Client> retrieveAllClients();
    Client addClient(Client client);
    Client updateClient(Client client);
    Optional<Client> retrieveClient(Long idClient);

    void removeClient(Long idClient);

}
