package com.rti.market.persistence.mapper;

import com.rti.market.domain.Purchase;
import com.rti.market.persistence.entity.Buy;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "idBuy", target = "purchaseId"),
            @Mapping(source = "idCustomer", target = "clientId"),
            @Mapping(source = "products", target = "items"),
    })
    Purchase toPurchase(Buy buy);
    List<Purchase> toPurchases(List<Buy> buys);

    @InheritInverseConfiguration
    @Mapping(target = "customer", ignore = true)
    Buy toBuy(Purchase purchase);
}
