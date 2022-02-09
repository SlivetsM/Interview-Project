package com.slivets.itsm.rest;

import com.slivets.itsm.model.Product;
import com.slivets.itsm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long productId) {
        HttpHeaders headers = new HttpHeaders();
        if (productId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Product product = this.productService.getById(productId);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, headers, HttpStatus.OK);
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.productService.save(product);
        return new ResponseEntity<>(product, headers, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchResult(@RequestParam String keyword) {
        HttpHeaders headers = new HttpHeaders();
        List<Product> listProducts = this.productService.search(keyword);
        if (listProducts == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listProducts, headers, HttpStatus.OK);
    }

    @PostMapping("/increaseStockLevelByRetailer")
    public ResponseEntity<List<Product>> increaseStockLevelByRetailer(@RequestParam String retailerName) {
        HttpHeaders headers = new HttpHeaders();
        List<Product> productList = this.productService.increaseStockLevelByRetailer(retailerName);
        return new ResponseEntity<>(productList, headers, HttpStatus.OK);
    }
}
