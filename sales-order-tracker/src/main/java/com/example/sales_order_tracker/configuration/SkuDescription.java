package com.example.sales_order_tracker.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkuDescription {
    private String sku;
    private String description;
}
