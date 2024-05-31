package org.pfe.tn.Services;

import org.pfe.tn.entities.Stock;

import java.util.List;
import java.util.Optional;

public interface IStockService {

    List<Stock> retrieveAllStocks();
    Stock addStock(Stock stock);
    Stock updateStock(Stock stock);
    Optional<Stock> retrieveStock(Long idStock);

    void removeStock(Long idStock);
}
