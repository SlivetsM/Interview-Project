package com.slivets.itsm.service;

import com.slivets.itsm.model.Retailer;

import java.util.List;

public interface RetailersService {

    Retailer getById(Long id);

    void save(Retailer retailer);

    void delete(Long id);

    List<Retailer> getAll();

}
