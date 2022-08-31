package us.ryan.impl;

import us.ryan.Sale;
import us.ryan.iface.SalesReport;
import us.ryan.iface.ShippingPolicy;

import java.util.List;

public class DetailedSalesReport implements SalesReport {
    @Override
    public void generateReport(List<Sale> salesList, ShippingPolicy shippingPolicy){
        System.out.println("Generating Detailed Report");
        System.out.printf("%-20s %-20s %-10s %-10s %-10s%n", "Customer", "Country", "Amount", "Tax", "Shipping");
        System.out.printf("%-20s %-20s %-10s %-10s %-10s%n", "--------", "-------", "------", "---", "--------");
        for (Sale sale : salesList){
            double shippingPrice = shippingPolicy.applyShipping(sale);
            System.out.printf("%-20s %-20s %-10s %-10s %-10.2f%n", sale.getName(), sale.getCountry(), sale.getCost(), sale.getTax(), shippingPrice);
        }
    }
}
