package com.example.transactioninventoryadaptor.service;

import com.example.transactioninventoryadaptor.entity.ProductInventory;
import com.example.transactioninventoryadaptor.repositoty.ProductInventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductInventoryService {

    private final ProductInventoryRepository productInventoryRepository;

    public ProductInventoryService(ProductInventoryRepository productInventoryRepository) {
        this.productInventoryRepository = productInventoryRepository;
    }

    public void addInventory(ProductInventory productInventory) {
        productInventoryRepository.save(productInventory);
    }

    public ProductInventory getProductInventory(String sku) {
       return productInventoryRepository.findBySku(sku);
    }
}
