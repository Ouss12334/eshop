package com.eshop.products.persistence.model;

import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Entity
@NoArgsConstructor
@ToString(callSuper = true) // call super to log parent fields when needed
@EqualsAndHashCode(callSuper = true)
public class HealthAndVitaminsProduct extends Product {
    @Builder
    public HealthAndVitaminsProduct(String id, String name, String description, Integer weightGram, OffsetDateTime fabricationDate, OffsetDateTime expirationDate, int quantity, BigDecimal unitPrice, String currency, String imageUrl, String subType) {
        super(id, name, description, weightGram, fabricationDate, expirationDate, quantity, unitPrice, currency, imageUrl, subType);
    }
}
