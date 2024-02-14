package com.jasper.example.report.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private String lineNo;
    private String itemDesc;
    private String qtyOrdered;
    private String soldOum;
    private String pricingQty;
    private String pricingOum;
    private String unitPrice;
    private String total;
}
