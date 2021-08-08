package com.eshop.products.controller;

import com.eshop.products.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ProductController {

    @RequestMapping("/products/{type}")
    public List<Product> GetProduct(@PathVariable String type) {
        return Collections.emptyList();
    }
}
