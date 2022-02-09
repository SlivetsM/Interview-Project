package com.slivets.itsm.repository;

import com.slivets.itsm.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository interface  for {@link com.slivets.itsm.model.Product } class.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT c FROM Product c WHERE c.productName LIKE '%' || :keyword || '%'"
            + " OR c.description LIKE '%' || :keyword || '%'")
    List<Product> search(@Param("keyword") String keyword);

    @Query(value = "SELECT p FROM Product p INNER JOIN p.retailer r WHERE r.retailerName =:retailerName ")
    List<Product> searchByRetailerName(@Param("retailerName") String retailerName);
}