package org.pfe.tn.Services;

import org.pfe.tn.entities.Caissier;

import java.util.List;
import java.util.Optional;

public interface ICaissierService {

    List<Caissier> retrieveAllCaissier();
    Caissier addCaissier(Caissier Caissier);
    Caissier updateCaissier(Caissier Caissier);
    Optional<Caissier> retrieveCaissier(Long idCaissier);

    void removeCaissier(Long idCaissier);

    void removeClient(Long idCaissier);
}
