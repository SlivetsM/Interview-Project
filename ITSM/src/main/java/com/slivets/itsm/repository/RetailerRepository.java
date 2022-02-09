package com.slivets.itsm.repository;

import com.slivets.itsm.model.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface  for {@link com.slivets.itsm.model.Retailer } class.
 */
public interface RetailerRepository extends JpaRepository<Retailer, Long> {
}
