package com.accent.services;

import com.accent.entities.Stock;

import java.util.List;
import java.util.Optional;

public interface IstockService {
    List<Stock> getAllStocks();
    Optional<Stock> getStockById(int id);
    Stock saveStock(Stock stock);
    void deleteStockById(int id);
}
