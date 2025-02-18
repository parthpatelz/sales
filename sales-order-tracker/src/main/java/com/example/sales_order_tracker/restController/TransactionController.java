package com.example.sales_order_tracker.restController;

import com.example.sales_order_tracker.configuration.ApplicationConfig;
import com.example.sales_order_tracker.configuration.CanadaTaxConfig;
import com.example.sales_order_tracker.configuration.CanadaTaxes;
import com.example.sales_order_tracker.configuration.SkuDescription;
import com.example.sales_order_tracker.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TransactionController {

    private final ApplicationConfig applicationConfig;

    private final CanadaTaxConfig canadaTaxConfig;

    private final TransactionService transactionService;

    public TransactionController(ApplicationConfig applicationConfig, CanadaTaxConfig canadaTaxConfig, TransactionService transactionService) {
        this.applicationConfig = applicationConfig;
        this.canadaTaxConfig = canadaTaxConfig;
        this.transactionService = transactionService;
    }


    @GetMapping("/addRecord/{sku}")
    public String addRecord(@PathVariable String sku){
        transactionService.addNewRecord(sku);
        return "flow is triggered";
    }


    @GetMapping("/readFromConfig")
    public void readDataFromConfig(){
        System.out.println("Provincial:  "+ applicationConfig.getProvincial());
        System.out.println("Federal:  "+ applicationConfig.getFederal());

        System.out.println("-----------------");

        for(String day : applicationConfig.getDays()){
            System.out.println(day);
        }

        System.out.println("-----------------");

        for(SkuDescription skuDescription : applicationConfig.getSkuList()){
            System.out.println("Sku:  "+ skuDescription.getSku());
            System.out.println("Description:  "+ skuDescription.getDescription());
        }

        System.out.println("-----------------");

        for(Map.Entry<String, CanadaTaxes> entry: canadaTaxConfig.getTaxMap().entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println("-----------------");
        System.out.println("Application Name: " + applicationConfig.getApplicationName());
    }
}
