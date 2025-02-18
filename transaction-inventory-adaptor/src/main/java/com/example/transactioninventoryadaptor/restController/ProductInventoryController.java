package com.example.transactioninventoryadaptor.restController;


import com.example.transactioninventoryadaptor.entity.ProductInventory;
import com.example.transactioninventoryadaptor.service.ProductInventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ProductInventoryController {

   private final ProductInventoryService productInventoryService;


    public ProductInventoryController(ProductInventoryService productInventoryService) {
        this.productInventoryService = productInventoryService;
    }

    @PostMapping("/addProductInventory")
    public String addNewProduct(@RequestBody ProductInventory productInventory){
        productInventoryService.addInventory(productInventory);
        return "Product is added Successfully !!";
    }

    @GetMapping("/product/{sku}")
    public ProductInventory getProductBySku(@PathVariable String sku){
        return productInventoryService.getProductInventory(sku);
    }

}
