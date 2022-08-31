package us.ryan.impl;

import us.ryan.Sale;
import us.ryan.iface.ShippingPolicy;

public class FreeShippingPolicy implements ShippingPolicy {
    @Override
    public double applyShipping(Sale sale) {
        return 0;
    }
}
