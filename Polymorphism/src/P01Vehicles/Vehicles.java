package P01Vehicles;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public abstract class Vehicles {
    protected double fuel;
    protected double fuelConsumption;

    protected Vehicles(double fuel, double fuelConsumption){
        setFuelConsumption(fuelConsumption);
        this.fuel = fuel;
    }
    public abstract void refuel(double liters);
    protected abstract void setFuelConsumption(double fuelConsumption);

    public double getFuelQuantity() {
        return this.fuel;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    public String drive(double km) {
        String result;
        DecimalFormat hashes = new DecimalFormat("#.##");
        double fuelToConsume = km*this.fuelConsumption;
        if (fuelToConsume <= this.fuel){
            result = String.format("travelled %s km", hashes.format(km));
            this.fuel -= fuelToConsume;
        }else {
            result = "needs refueling";
        }
        return result;
    }
}
