package us.ryan.iface;

import us.ryan.Sale;

import java.util.List;

public interface SalesReport {
    void generateReport(List<Sale> salesList, ShippingPolicy shippingPolicy);
}
