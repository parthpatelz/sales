package com.example.sales_order_tracker.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@Data
@ConfigurationProperties(prefix = "canada-taxes")
public class CanadaTaxConfig {

    private Map<String, CanadaTaxes> taxMap;
}
