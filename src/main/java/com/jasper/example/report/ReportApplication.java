package com.jasper.example.report;

import com.jasper.example.report.model.Item;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.*;

@SpringBootApplication
public class ReportApplication {

	public static void main(String[] args) throws JRException, IOException {
		SpringApplication.run(ReportApplication.class, args);

		// To Update
		String filePath = "C:\\Users\\Van Omega\\IdeaProjects\\report\\src\\main\\resources\\templates\\invoice.jrxml";

		// [S] Table Contents
		List<Item> itemList = new ArrayList<>();
		Item item1 = new Item();
		item1.setLineNo("1.1");
		item1.setItemDesc("C1527BLK: GT COIL 15x027 BLACK");
		item1.setQtyOrdered("351");
		item1.setPricingOum("LB");
		item1.setPricingQty("351");
		item1.setSoldOum("LB");
		item1.setUnitPrice("3");
		item1.setTotal("1053.00");

		itemList.add(item1);

		Item item2 = new Item();
		item2.setLineNo("2.1");
		item2.setItemDesc("C1527BLK: GT COIL 15x027 BLACK");
		item2.setQtyOrdered("1000");
		item2.setPricingOum("LF");
		item2.setPricingQty("1000");
		item2.setSoldOum("LF");
		item2.setUnitPrice("1.25");
		item2.setTotal("1250.00");
		itemList.add(item2);

		Item item3 = new Item();
		item3.setLineNo("3.1");
		item3.setItemDesc("C1527BLK: GT COIL 15x027 BLACK");
		item3.setQtyOrdered("1000");
		item3.setPricingOum("LF");
		item3.setPricingQty("1000");
		item3.setSoldOum("LF");
		item3.setUnitPrice("1.25");
		item3.setTotal("1250.00");
		itemList.add(item3);

		/*
		Item item4 = new Item();
		item4.setLineNo("4.1");
		item4.setItemDesc("C1527BLK: GT COIL 15x027 BLACK");
		item4.setQtyOrdered("1000");
		item4.setPricingOum("LF");
		item4.setPricingQty("1000");
		item4.setSoldOum("LF");
		item4.setUnitPrice("1.25");
		item4.setTotal("1250.00");
		itemList.add(item3);
		 */
		// [E] Table Contents

		JRBeanCollectionDataSource itemDataSource = new JRBeanCollectionDataSource(itemList);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("acctNo", "177222");
		parameters.put("terms", "30 Days NET");
		parameters.put("orderedBy", "SOLEDAD 863.701.4616");
		parameters.put("salesPerson", "Hopper, Jeremy Joseph");
		parameters.put("freightTerms", "");
		parameters.put("billTo", "TROPICAL SEAMLESS GUTTERS OF CENTRAL FL 4326 STEPHANIE WAY BARTOW FL 33830-9531");
		parameters.put("shipTo", "TROPICAL SEAMLESS GUTTERS OF CENTRAL FL - BARTOW - SP 4326 STEPHANIE WAY BARTOW FL 33830-9531");
		parameters.put("orderNo", "12345");
		parameters.put("orderDate", new Date().toString());
		parameters.put("customerPoNo", "SOLEDAD");
		parameters.put("shipVia", "Del-Our Truck");
		parameters.put("totalWeight", "871.17 lbs");
		parameters.put("reqDelDateTime", "01/22/24 - 12:00 AM");
		parameters.put("customerNotes", "This is a test invoice template");
		parameters.put("specInstruction", "COD - NO FUEL SURCHARGE");
		parameters.put("sendMethod", "");
		parameters.put("enteredBy", "Kotha, Pranay");
		parameters.put("subtotal", "3,042.69");
		parameters.put("addCharges", "0.00");
		parameters.put("freight", "53.00");
		parameters.put("discounts", "0.00");
		parameters.put("tax", "212.99");
		parameters.put("total", "3,308.68");
		parameters.put("itemDataset", itemDataSource);

		JasperReport report = JasperCompileManager.compileReport(filePath);
		JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());

		//TO Update
		JasperExportManager.exportReportToPdfFile(print, "C:\\pdf\\invoice.pdf");

		System.out.println("Done Generating PDF!");
		System.exit(0);
	}

}