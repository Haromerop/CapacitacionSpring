package com.rti.market.persistence;

import com.rti.market.domain.Purchase;
import com.rti.market.domain.repository.PurchaseRepository;
import com.rti.market.persistence.crud.BuyCrudRepository;
import com.rti.market.persistence.entity.Buy;
import com.rti.market.persistence.mapper.PurchaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BuyRepository implements PurchaseRepository {

    private final BuyCrudRepository buyCrudRepository;
    private final PurchaseMapper mapper;

    public BuyRepository(BuyCrudRepository buyCrudRepository, PurchaseMapper mapper) {
        this.buyCrudRepository = buyCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Buy>) buyCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return buyCrudRepository.findByIdCustomer(clientId).map(mapper::toPurchases);
    }

    @Override
    public Purchase save(Purchase purchase) {
        Buy buy = mapper.toBuy(purchase);
        buy.getProducts().forEach(product -> product.setBuy(buy));
        return mapper.toPurchase(buyCrudRepository.save(buy));
    }
}
