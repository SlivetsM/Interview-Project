package com.slivets.itsm.service;

import com.slivets.itsm.model.Product;
import com.slivets.itsm.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        log.info("IN ProductServiceImpl save{}", product);
        productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        log.info("IN ProductServiceImpl getById{}", id);
        return productRepository.getById(id);
    }

    @Override
    public List<Product> search(String keywords) {
        log.info("IN ProductServiceImpl search{}", keywords);
        return productRepository.search(keywords);
    }

    @Override
    public List<Product> getAll() {
        log.info("IN ProductServiceImpl getAll{}");
        return productRepository.findAll();
    }

    @Override
    public List<Product> increaseStockLevelByRetailer(String retailerName) {
        log.info("IN ProductServiceImpl increaseStockLevelByRetailer{}");
        List<Product> products = productRepository.searchByRetailerName(retailerName);
        if (retailerName.equals("RetA")) {
            productRepository.search("RetA");
            for (Product product1 : products) {
                product1.setStockLevel(product1.getStockLevel() + 5);
                productRepository.save(product1);
            }

        }
        if (retailerName.equals("RetB")) {
            productRepository.search("RetB");
            for (Product product1 : products) {
                product1.setStockLevel(product1.getStockLevel() + 8);
                productRepository.save(product1);
            }
        }
        return productRepository.searchByRetailerName(retailerName);
    }
}
