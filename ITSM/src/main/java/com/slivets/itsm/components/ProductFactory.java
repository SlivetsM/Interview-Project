package com.slivets.itsm.components;

import com.slivets.itsm.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFactory {
    public static Product createPurchase() {
        return new Product();
    }
}
