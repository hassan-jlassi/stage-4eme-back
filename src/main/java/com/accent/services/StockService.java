package com.accent.services;

import com.accent.entities.Stock;
import com.accent.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService implements IstockService{
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Optional<Stock> getStockById(int id) {
        return stockRepository.findById(id);
    }

    @Override
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void deleteStockById(int id) {
        stockRepository.deleteById(id);
    }
}
