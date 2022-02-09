package com.slivets.itsm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * JavaBean domain object that represent Retailer
 */
@Entity
@Table(name = "retailers")
@Getter
@Setter
@ToString
public class Retailer extends BaseEntity{
    private String retailerName;
    @JsonIgnore
    @OneToMany(mappedBy = "retailer")
    private List<Product> products;
}
