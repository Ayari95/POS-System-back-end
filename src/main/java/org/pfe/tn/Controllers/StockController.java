package org.pfe.tn.Controllers;

import org.pfe.tn.entities.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.pfe.tn.Services.IStockService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("Stock")

public class StockController {

    @Autowired
    IStockService iStockService;
    @GetMapping
    public List<Stock> getAll(){
        return iStockService.retrieveAllStocks();

    }
    @GetMapping("{idStock}")

    public Optional<Stock> retrieveInscription(@PathVariable Long idStock) {

        return  iStockService.retrieveStock(idStock);

    }
    @PostMapping

    public Stock addInscription(@RequestBody Stock stock){

        return iStockService.addStock(stock);
    }
    @DeleteMapping("{idStock}")
    public void removeInscription(@PathVariable Long idStock){

        iStockService.removeStock(idStock);
    }

    @PutMapping
    public Stock updateInscription(@RequestBody Stock stock) {

        return  iStockService.updateStock(stock);

    }
}
