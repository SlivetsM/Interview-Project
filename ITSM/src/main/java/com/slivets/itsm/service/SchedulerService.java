package com.slivets.itsm.service;

import com.slivets.itsm.components.Constants;
import com.slivets.itsm.model.Product;
import com.slivets.itsm.repository.ProductRepository;
import com.slivets.itsm.components.ProductFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class SchedulerService {
    private String[] name = {"Soap", "Shampoo", "Perfume", "Toothbrush", "washing powder", "washcloth"};
    private String[] description = {"Suitable for children", "Especially for men", "Especially for women"};
    private ProductRepository productRepository;

    @Autowired
    public SchedulerService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Scheduled(fixedDelayString = "${schedule.work}")
    public void schedulerSave() {
        for (int i = 0; i < Constants.NUM_OF_RANDOM_PROD; i++) {
            Product randomProduct = ProductFactory.createPurchase();
            int n = (int) Math.floor(Math.random() * name.length);
            int d = (int) Math.floor(Math.random() * description.length);
            randomProduct.setProductName(name[n]);
            randomProduct.setDescription(description[d]);
            randomProduct.setStockLevel((int) Math.floor(Math.random() * 19));
            productRepository.save(randomProduct);
        }
    }
}
