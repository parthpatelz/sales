package com.example.transaction_finance_service.repository;


import com.example.transaction_finance_service.entity.FinanceTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FinanceTransactionRepository extends JpaRepository<FinanceTransaction, Long> {
    Optional<FinanceTransaction> findBySku(String sku);
}
