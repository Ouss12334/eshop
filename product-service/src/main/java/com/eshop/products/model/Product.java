package com.eshop.products.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * view model for the product returned by the api.
 * this is done to control what is returned through the api.
 */
@Data
public class Product {

    private String id;

    private String name;

    private String description;

    private OffsetDateTime fabricationDate;

    private OffsetDateTime expirationDate;

    private BigDecimal price;

    private String currency;

    private String imageUrl;

}
