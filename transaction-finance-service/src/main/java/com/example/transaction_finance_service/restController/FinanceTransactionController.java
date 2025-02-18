package com.example.transaction_finance_service.restController;

import com.example.transaction_finance_service.entity.FinanceTransaction;
import com.example.transaction_finance_service.service.FinanceTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FinanceTransactionController {

    private final FinanceTransactionService service;

    public FinanceTransactionController(FinanceTransactionService service) {
        this.service = service;
    }

    @GetMapping("/finance/{sku}")
    public Optional<FinanceTransaction> getFinanceDetail(@PathVariable String sku) {
        return service.getFinanceDetail(sku);
    }

    @PostMapping("/addFinanceTransaction")
    public String createFinanceTransaction(@RequestBody FinanceTransaction financeTransaction) {
        service.saveFinanceTransaction(financeTransaction);
        return "Price is added Successfully";
    }
}
