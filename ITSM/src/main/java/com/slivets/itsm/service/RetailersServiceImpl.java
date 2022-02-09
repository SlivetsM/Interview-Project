package com.slivets.itsm.service;

import com.slivets.itsm.model.Retailer;
import com.slivets.itsm.repository.RetailerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Slf4j
@Service
public class RetailersServiceImpl implements RetailersService {

    private RetailerRepository retailerRepository;

    @Autowired
    public RetailersServiceImpl(RetailerRepository retailerRepository) {
        this.retailerRepository = retailerRepository;
    }

    @Override
    public Retailer getById(Long id) {
        log.info("IN RetailersServiceImpl getById{}", id);
        return retailerRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Retailer retailer) {
        log.info("IN RetailersServiceImpl save{}", retailer);
        retailerRepository.save(retailer);
    }

    @Override
    public void delete(Long id) {
        log.info("IN RetailersServiceImpl delete{}", id);
        retailerRepository.deleteById(id);
    }

    @Override
    public List<Retailer> getAll() {
        log.info("IN RetailersServiceImpl getAll{}");
        return retailerRepository.findAll();
    }
}
