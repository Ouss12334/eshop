package com.eshop.products.persistence.model;

import jdk.jfr.Unsigned;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * base product for all product kinds
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
// name of the column for inheritance (just to remember)
@DiscriminatorColumn(name = "product_type")
public class Product {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "weight_gram")
    private Integer weightGram;

    @Column(name = "fabrication_date")
    private OffsetDateTime fabricationDate;

    @Column(name = "expiration_date")
    private OffsetDateTime expirationDate;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price", scale = 5, precision = 25)
    private BigDecimal unitPrice;

    @Column(name = "discount_price", scale = 5, precision = 25)
    private BigDecimal discountPrice;

    @Column(name = "currency")
    private String currency;

    @Column(name = "image_url")
    private String imageUrl;

    // type of the child product (eg: dtype=food, subType=fresh)
    @Column(name = "sub_type")
    private String subType;
}
