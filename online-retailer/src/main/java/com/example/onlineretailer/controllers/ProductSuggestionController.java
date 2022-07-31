package com.example.onlineretailer.controllers;

import com.example.onlineretailer.entities.ProductSuggestion;
import com.example.onlineretailer.repositories.ProductSuggestionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/product-suggestion", produces = {"application/json", "application/xml"})
@CrossOrigin
public class ProductSuggestionController {

    private static ResponseEntity<Boolean> booleanResponse(boolean hasChanged) {
        if (hasChanged) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    private final ProductSuggestionRepository productSuggestionRepository;

    public ProductSuggestionController(ProductSuggestionRepository productSuggestionRepository) {
        this.productSuggestionRepository = productSuggestionRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<ProductSuggestion>> getAllProductSuggestions() {
        return ResponseEntity.ok(this.productSuggestionRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductSuggestion> getProductSuggestionById(@PathVariable long id) {
        return ResponseEntity.ok(this.productSuggestionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @PostMapping
    public ResponseEntity<ProductSuggestion> createProductSuggestion(@RequestBody ProductSuggestion body) {
        return ResponseEntity.ok(this.productSuggestionRepository.save(body));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAllProductSuggestions() {
        this.productSuggestionRepository.deleteAll();
        return ResponseEntity.ok(true);
    }

    @GetMapping("modifyPrice/{id}")
    public ResponseEntity<Boolean> modifyPrice(@RequestParam double newPrice, @PathVariable long id) {
        return booleanResponse(this.productSuggestionRepository.updateRecommendedPriceById(newPrice, id) > 0);
    }

    @GetMapping("modifySales/{id}")
    public ResponseEntity<Boolean> modifySales(@RequestParam double newSales, @PathVariable long id) {
        return booleanResponse(this.productSuggestionRepository.updateEstimatedAnnualSalesById(newSales, id) > 0);
    }
}
