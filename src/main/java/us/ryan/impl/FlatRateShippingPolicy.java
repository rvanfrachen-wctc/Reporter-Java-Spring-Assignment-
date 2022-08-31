package us.ryan.impl;

import us.ryan.Sale;
import us.ryan.iface.ShippingPolicy;

public class FlatRateShippingPolicy implements ShippingPolicy {
    @Override
    public double applyShipping(Sale sale) {
        return sale.getCost() / 10;
//        System.out.printf("%-20s %-20s %-10s %-10s %-10.2f%n", sale.getName(), sale.getCountry(), sale.getCost(), sale.getTax(), shippingPrice);
    }
}
