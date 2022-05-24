package com.rti.market.persistence.mapper;

import com.rti.market.domain.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "state", target = "active")
    })
    Category toCategory(com.rti.market.persistence.entity.Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    com.rti.market.persistence.entity.Category toCategoryPersistence(Category category);
}
