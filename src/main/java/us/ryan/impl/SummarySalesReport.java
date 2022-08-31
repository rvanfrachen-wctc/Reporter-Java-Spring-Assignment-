package us.ryan.impl;

import us.ryan.Sale;
import us.ryan.iface.SalesReport;
import us.ryan.iface.ShippingPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SummarySalesReport implements SalesReport {
    @Override
    public void generateReport(List<Sale> salesList, ShippingPolicy shippingPolicy) {
        System.out.println("Generating Summary Report");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Country", "Amount", "Tax", "Shipping");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "-------", "------", "---", "--------");
        List<Sale> summarySales = new ArrayList<>();
        for(Sale sale : salesList){
            boolean found = false;
            for (Sale summarySale : summarySales){
                if (Objects.equals(summarySale.getCountry(), sale.getCountry())) {
                    found = true;
                    break;
                }
            }
            if(!found){
                summarySales.add(sale);
            }else{
                for (Sale summarySale : summarySales){
                    if (Objects.equals(summarySale.getCountry(), sale.getCountry())) {
                        summarySale.setCost(summarySale.getCost() + sale.getCost());
                        summarySale.setTax(summarySale.getTax() + sale.getTax());
                    }
                }
            }
        }
        for (Sale sale : summarySales){
            double shippingPrice = shippingPolicy.applyShipping(sale);
            System.out.printf("%-20s %-10s %-10s %-10.2f%n", sale.getCountry(), sale.getCost(), sale.getTax(), shippingPrice);
        }
    }
}
