package com.example.sales_order_tracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinanceTransaction {
    private Long id;
    private String sku;
    private Double price;
}
