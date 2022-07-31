package com.example.onlineretailer.repositories;

import com.example.onlineretailer.entities.ProductSuggestion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProductSuggestionRepository extends CrudRepository<ProductSuggestion, Long> {
    @Transactional
    @Modifying
    @Query("update product_suggestion p set p.recommendedPrice = ?1 where p.id = ?2")
    int updateRecommendedPriceById(Double recommendedPrice, Long id);

    @Transactional
    @Modifying
    @Query("update product_suggestion p set p.estimatedAnnualSales = ?1 where p.id = ?2")
    int updateEstimatedAnnualSalesById(Double estimatedAnnualSales, Long id);

}