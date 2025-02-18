package com.example.sales_order_tracker.serviceClient;

import com.example.sales_order_tracker.entity.FinanceTransaction;
import com.example.sales_order_tracker.entity.ProductInventory;
import com.example.sales_order_tracker.entity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class FinanceServiceClient {

    @Value("${transactionFinanceService.urlTemplate}")
    private String urlTemplate;

    private final RestTemplate restTemplate;

    public FinanceServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public FinanceTransaction getFinanceDetails(String sku) {
        FinanceTransaction financeTransaction = null;
        try{
            financeTransaction = restTemplate.getForObject(urlTemplate, FinanceTransaction.class, sku);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return financeTransaction;
    }
}