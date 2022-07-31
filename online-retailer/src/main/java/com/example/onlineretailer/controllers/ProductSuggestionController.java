package com.example.onlineretailer.controllers;

import com.example.onlineretailer.DataKafka;
import com.example.onlineretailer.entities.ProductSuggestion;
import com.example.onlineretailer.repositories.ProductSuggestionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/product-suggestion", produces = {"application/json", "application/xml"})
@CrossOrigin
public class ProductSuggestionController {

    public static final String TOPIC_NAME = "product_suggestions_topic";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    private final ProductSuggestionRepository productSuggestionRepository;


    public ProductSuggestionController(ProductSuggestionRepository productSuggestionRepository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.productSuggestionRepository = productSuggestionRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    private static ResponseEntity<Boolean> booleanResponse(boolean hasChanged) {
        if (hasChanged) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
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
    public ResponseEntity<ProductSuggestion> insertProductSuggestion(@RequestBody ProductSuggestion body) {
        this.kafkaTemplate.send(TOPIC_NAME, "inserted", body);
        return ResponseEntity.ok(this.productSuggestionRepository.save(body));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAllProductSuggestions() {
        this.productSuggestionRepository.deleteAll();
        return ResponseEntity.ok(true);
    }

    @GetMapping("modifyPrice/{id}")
    public ResponseEntity<Boolean> modifyPrice(@RequestParam double newPrice, @PathVariable long id) {
        this.kafkaTemplate.send(TOPIC_NAME, "modifiedPrice", new DataKafka(id, newPrice));
        return booleanResponse(this.productSuggestionRepository.updateRecommendedPriceById(newPrice, id) > 0);
    }

    @GetMapping("modifySales/{id}")
    public ResponseEntity<Boolean> modifySales(@RequestParam double newSales, @PathVariable long id) {
        this.kafkaTemplate.send(TOPIC_NAME, "modifiedSales", new DataKafka(id, newSales));
        return booleanResponse(this.productSuggestionRepository.updateEstimatedAnnualSalesById(newSales, id) > 0);
    }
}
