package org.pfe.tn.Services;

import org.pfe.tn.Repositories.ClientRepository;
import org.pfe.tn.entities.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IClientServiceImp implements IClientService {
    private final ClientRepository clientRepository;
    @Override
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> retrieveClient(Long idClient) {
        return clientRepository.findById(idClient);
    }

    @Override
    public void removeClient(Long idClient) {
            clientRepository.deleteById(idClient);
    }
}
