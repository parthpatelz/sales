package com.example.sales_order_tracker.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CanadaTaxes {

    private String province;
    private String taxes;
}
