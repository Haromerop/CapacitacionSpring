package com.rti.market.persistence.mapper;

import com.rti.market.domain.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "stockQuantity", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "category", target = "category")
    })
    Product toProduct(com.rti.market.persistence.entity.Product product);
    List<Product> toProducts(List<com.rti.market.persistence.entity.Product> products);
    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    com.rti.market.persistence.entity.Product toProductPersistence(Product product);
}
