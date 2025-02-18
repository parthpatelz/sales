package com.example.transactioninventoryadaptor.repositoty;

import com.example.transactioninventoryadaptor.entity.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductInventory,Integer> {

    ProductInventory findBySku(String sku);
}
