package com.accent.controllers;

import com.accent.entities.Stock;
import com.accent.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/")
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public Optional<Stock> getStockById(@PathVariable("id") int id) {
        return stockService.getStockById(id);
    }

    @PostMapping("/")
    public Stock saveStock(@RequestBody Stock stock) {
        return stockService.saveStock(stock);
    }

    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable("id") int id, @RequestBody Stock updatedStock) {
        Optional<Stock> existingStock = stockService.getStockById(id);

        if (existingStock.isPresent()) {
            Stock stockToUpdate = existingStock.get();
            stockToUpdate.setNumSerie(updatedStock.getNumSerie());
            stockToUpdate.setIMEI(updatedStock.getIMEI());
            stockToUpdate.setDateProduction(updatedStock.getDateProduction());
            stockToUpdate.setCategorie(updatedStock.getCategorie());

            return stockService.saveStock(stockToUpdate);
        } else {
            throw new RuntimeException("Stock not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStockById(@PathVariable("id") int id) {
        stockService.deleteStockById(id);
    }
}
