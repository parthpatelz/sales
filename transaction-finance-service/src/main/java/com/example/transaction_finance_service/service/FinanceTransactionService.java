package com.example.transaction_finance_service.service;

import com.example.transaction_finance_service.entity.FinanceTransaction;
import com.example.transaction_finance_service.repository.FinanceTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FinanceTransactionService {

    private final FinanceTransactionRepository repository;

    public FinanceTransactionService(FinanceTransactionRepository repository) {
        this.repository = repository;
    }

    public Optional<FinanceTransaction> getFinanceDetail(String sku) {
        return repository.findBySku(sku);
    }
    public FinanceTransaction saveFinanceTransaction(FinanceTransaction financeTransaction) {
        return repository.save(financeTransaction);
    }
}
