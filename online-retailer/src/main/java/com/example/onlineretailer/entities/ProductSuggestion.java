package com.example.onlineretailer.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "product_suggestion")
public class ProductSuggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "recommended_price")
    private Double recommendedPrice;

    @Column(name = "estimated_annual_sales")
    private Double estimatedAnnualSales;

}
