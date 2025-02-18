package com.example.sales_order_tracker.service;

import com.example.sales_order_tracker.entity.FinanceTransaction;
import com.example.sales_order_tracker.entity.ProductInventory;
import com.example.sales_order_tracker.entity.Transaction;
import com.example.sales_order_tracker.repository.TransactionRepository;
import com.example.sales_order_tracker.serviceClient.InventoryServiceClient;
import com.example.sales_order_tracker.serviceClient.FinanceServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.sales_order_tracker.entity.Transaction.*;

@Service
@Slf4j
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final InventoryServiceClient inventoryServiceClient;

    private final FinanceServiceClient financeServiceClient;


    public TransactionService(TransactionRepository transactionRepository, InventoryServiceClient inventoryServiceClient, FinanceServiceClient financeServiceClient) {
        this.transactionRepository = transactionRepository;
        this.inventoryServiceClient = inventoryServiceClient;
        this.financeServiceClient = financeServiceClient;
    }

    public void addNewRecord(String sku){

        ProductInventory productInventory = inventoryServiceClient.getInventoryDetails(sku);

        if (productInventory != null) {
            FinanceTransaction financeDetails = financeServiceClient.getFinanceDetails(sku);

            if (financeDetails != null) {
                transactionRepository.save(getTransactionToStore(productInventory, financeDetails));
            } else {
                log.error("Finance details not found for the given Sku: {}", sku);
            }
        } else {
            log.error("Inventory not found for the given Sku: {}", sku);
        }
    }


    public Transaction getTransactionToStore(ProductInventory productInventory, FinanceTransaction financeTransaction) {
        return Transaction.builder()
                .sku(productInventory.getSku())
                .Quantity(productInventory.getQuantity())
                .Price(financeTransaction.getPrice())
                .localDateTime(LocalDateTime.now()).build();
    }
}
