package org.pfe.tn.Services;

import org.pfe.tn.Repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class IAbonnementServiceImp implements IAbonnementService{
    private final ClientRepository clientRepository;

}
