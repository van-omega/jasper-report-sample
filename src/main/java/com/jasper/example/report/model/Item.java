package com.jasper.example.report.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private String lineNo;
    private String itemDesc;
    private int qtyOrdered;
    private String soldOum;
    private int pricingQty;
    private String pricingOum;
    private BigDecimal unitPrice;
    private BigDecimal total;
}
