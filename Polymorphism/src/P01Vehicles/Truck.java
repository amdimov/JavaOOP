package P01Vehicles;

public class Truck extends Vehicles{

    public Truck(double fuel, double fuelConsumption){
        super(fuel, fuelConsumption);
    }

    @Override
    public void refuel(double liters) {
        liters = liters * 0.95;
        super.fuel += liters;
    }
    @Override
    public void setFuelConsumption(double fuelConsumption) {
        fuelConsumption += 1.6;
        this.fuelConsumption = fuelConsumption;
    }
}
