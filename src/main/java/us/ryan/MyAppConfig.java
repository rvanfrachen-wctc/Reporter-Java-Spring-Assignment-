package us.ryan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import us.ryan.iface.SalesInput;
import us.ryan.iface.SalesReport;
import us.ryan.iface.ShippingPolicy;
import us.ryan.impl.*;

@Configuration
@ComponentScan("us.ryan")
public class MyAppConfig {
    @Bean
    public SalesInput salesInput(){
        return new FileInput();
    }
    @Bean
    public ShippingPolicy shippingPolicy() {
//        return new FreeShippingPolicy();
        return new FlatRateShippingPolicy();
    }
    @Bean
    public SalesReport salesReport(){
//        return new DetailedSalesReport();
        return new SummarySalesReport();
    }
}
