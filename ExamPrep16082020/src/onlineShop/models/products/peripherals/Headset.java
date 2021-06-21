package onlineShop.models.products.peripherals;

import onlineShop.models.products.BaseProduct;

public class Headset extends BasePeripheral {
    public Headset(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance, connectionType);
    }
}
