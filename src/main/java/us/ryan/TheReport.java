package us.ryan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.ryan.iface.SalesInput;
import us.ryan.iface.SalesReport;
import us.ryan.iface.ShippingPolicy;

import java.util.List;

@Component
public class TheReport {
    private SalesInput theInput;
    private ShippingPolicy shippingPolicy;
    private SalesReport salesReport;

    @Autowired
    public TheReport(SalesInput theInput, ShippingPolicy shippingPolicy, SalesReport salesReport) {
        this.theInput = theInput;
        this.shippingPolicy = shippingPolicy;
        this.salesReport = salesReport;
        System.out.println("Report is running");
    }

    public void run(){
        List<Sale> sales = theInput.getSales();
        salesReport.generateReport(sales, shippingPolicy);
    }
}
