package com.slivets.itsm.rest;

import com.slivets.itsm.model.Retailer;
import com.slivets.itsm.service.RetailersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/retailers/")
public class RetailerController {

    private RetailersService retailersService;

    @Autowired
    public RetailerController(RetailersService retailersService) {
        this.retailersService = retailersService;
    }

    @GetMapping("/getRetailerById/{id}")
    public ResponseEntity<Retailer> getRetailerById(@PathVariable("id") Long retailerId) {
        HttpHeaders headers = new HttpHeaders();
        if (retailerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Retailer retailer = this.retailersService.getById(retailerId);
        if (retailer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(retailer, headers, HttpStatus.OK);
    }
}