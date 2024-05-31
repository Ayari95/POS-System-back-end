package org.pfe.tn.Services;

import org.pfe.tn.Repositories.StockRepository;
import org.pfe.tn.entities.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class IStockServiceImp implements IStockService {
    private final StockRepository stockRepository;
    @Override
    public List<Stock> retrieveAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Optional<Stock> retrieveStock(Long idSock) {
        return stockRepository.findById(idSock);
    }

    @Override
    public void removeStock(Long idSock) {
        stockRepository.deleteById(idSock);
    }
}
