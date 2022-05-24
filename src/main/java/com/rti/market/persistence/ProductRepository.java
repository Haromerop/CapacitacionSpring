package com.rti.market.persistence;

import com.rti.market.persistence.crud.ProductCrudRepository;
import com.rti.market.persistence.entity.Product;
import com.rti.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements com.rti.market.domain.repository.ProductRepository {

    private final ProductCrudRepository productCrudRepository;
    private final ProductMapper mapper;

    public ProductRepository(ProductCrudRepository productCrudRepository, ProductMapper mapper) {
        this.productCrudRepository = productCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<com.rti.market.domain.Product> getAll(){
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<com.rti.market.domain.Product>> getByCategory(int categoryId){
        List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<com.rti.market.domain.Product>> getScarseProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockQuantityLessThanAndState(quantity, true);
        return products.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<com.rti.market.domain.Product> getProduct(int productId){
        return productCrudRepository.findById(productId).map(product -> mapper.toProduct(product));
    }

    @Override
    public com.rti.market.domain.Product save(com.rti.market.domain.Product product) {
        Product productDb = mapper.toProductPersistence(product);
        return mapper.toProduct(productCrudRepository.save(productDb));
    }

    @Override
    public void delete(int idProduct){
        productCrudRepository.deleteById(idProduct);
    }
}
