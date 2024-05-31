package org.pfe.tn.Repositories;

import org.pfe.tn.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long > {
}
