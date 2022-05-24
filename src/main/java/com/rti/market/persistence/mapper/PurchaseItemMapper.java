package com.rti.market.persistence.mapper;

import com.rti.market.domain.PurchaseItem;
import com.rti.market.persistence.entity.BuyProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "amount", target = "quantity"),
            @Mapping(source = "state", target = "active")
    })
    PurchaseItem toPurchaseItem(BuyProduct product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "buy", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idBuy", ignore = true)
    })
    BuyProduct toBuyProduct(PurchaseItem purchaseItem);
}
