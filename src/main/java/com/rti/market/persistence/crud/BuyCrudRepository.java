package com.rti.market.persistence.crud;

import com.rti.market.persistence.entity.Buy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BuyCrudRepository extends CrudRepository<Buy, Integer> {
    Optional<List<Buy>> findByIdCustomer(String idCustomer);
}
