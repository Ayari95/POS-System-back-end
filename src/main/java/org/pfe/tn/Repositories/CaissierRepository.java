package org.pfe.tn.Repositories;

import org.pfe.tn.entities.Caissier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaissierRepository extends JpaRepository<Caissier,Long > {

}


