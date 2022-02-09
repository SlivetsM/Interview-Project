package com.slivets.itsm.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
public class Product extends BaseEntity {
    private String productName;
    private String description;
    private int stockLevel;
    @ManyToOne()
    private Retailer retailer;
}
