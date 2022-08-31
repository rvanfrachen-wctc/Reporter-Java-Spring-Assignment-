package us.ryan.iface;

import us.ryan.Sale;

public interface ShippingPolicy {
    double applyShipping(Sale sale);
}
