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
@EqualsAndHashCode(callSuper = true)
public class FoodProduct extends Product {

    // this along @NoArgsCtor allows to use builder with parent. this is because lombok doesn't take superclass fields in consideration
    @Builder
    public FoodProduct(String id, String name, String description, OffsetDateTime fabricationDate, OffsetDateTime expirationDate, BigDecimal price, String currency, String imageUrl, String subType) {
        super(id, name, description, fabricationDate, expirationDate, price, currency, imageUrl, subType);
    }
}


