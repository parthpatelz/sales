package com.example.sales_order_tracker.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Data
@ConfigurationProperties(prefix = "application-config")
public class ApplicationConfig {

    private String provincial;

    private String federal;

    private List<String> days;

    private List<SkuDescription> skuList;

    private String applicationName;
}
