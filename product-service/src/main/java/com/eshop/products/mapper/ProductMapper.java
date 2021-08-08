package com.eshop.products.mapper;

import com.eshop.products.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    List<Product> toProductsApi(List<? extends com.eshop.products.persistence.model.Product> products);
}
