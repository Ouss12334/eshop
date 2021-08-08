package com.eshop.products.persistence.model;

import lombok.*;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Entity
@NoArgsConstructor
@ToString(callSuper = true) // call super to log parent fields when needed
@EqualsAndHashCode(callSuper = true)
public class FoodProduct extends Product {

    // this along @NoArgsCtor allows to use builder with parent. this is because lombok doesn't take superclass fields in consideration
    @Builder
    public FoodProduct(String id, String name, String description, Integer weightGram, OffsetDateTime fabricationDate, OffsetDateTime expirationDate, int quantity, BigDecimal unitPrice, BigDecimal discountPrice, String currency, String imageUrl, String subType) {
        super(id, name, description, weightGram, fabricationDate, expirationDate, quantity, unitPrice, discountPrice, currency, imageUrl, subType);
    }
}


