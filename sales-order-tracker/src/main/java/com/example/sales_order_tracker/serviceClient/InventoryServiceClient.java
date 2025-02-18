package com.example.sales_order_tracker.serviceClient;

import com.example.sales_order_tracker.entity.ProductInventory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class InventoryServiceClient {

    @Value("${transactionInventoryAdaptor.urlTemplate}")
    private String urlTemplate;

    private final RestTemplate restTemplate;

    public InventoryServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public ProductInventory getInventoryDetails(String sku){
        ProductInventory productInventory =null;
        try{
             productInventory =  restTemplate.getForObject(urlTemplate, ProductInventory.class, sku);

        }catch(Exception e){
            log.error(e.getMessage());
        }
        return productInventory;

    }

}
