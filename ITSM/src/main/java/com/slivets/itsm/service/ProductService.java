package com.slivets.itsm.service;

import com.slivets.itsm.model.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    Product getById(Long id);

    List<Product> search(String keyword);

    List<Product> getAll();

    List<Product> increaseStockLevelByRetailer(String retailerName);

}
