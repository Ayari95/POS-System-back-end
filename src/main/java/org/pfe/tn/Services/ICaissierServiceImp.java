package org.pfe.tn.Services;

import org.pfe.tn.entities.Caissier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ICaissierServiceImp implements ICaissierService {
    private final org.pfe.tn.Repositories.CaissierRepository CaissierRepository;
    @Override
    public List<Caissier> retrieveAllCaissier() {
        return CaissierRepository.findAll();
    }

    @Override
    public Caissier addCaissier(Caissier Caissier) {
        return CaissierRepository.save(Caissier);
    }

    @Override
    public Caissier updateCaissier(Caissier Caissier) {
        return CaissierRepository.save(Caissier);
    }

    @Override
    public Optional<Caissier> retrieveCaissier(Long idCaissier) {
        return CaissierRepository.findById(idCaissier);
    }

    @Override
    public void removeCaissier(Long idCaissier) {
        CaissierRepository.deleteById(idCaissier);
    }

    @Override
    public void removeClient(Long idCaissier) {

    }
}
