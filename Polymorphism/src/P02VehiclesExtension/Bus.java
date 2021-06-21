package P02VehiclesExtension;

public class Bus extends Vehicles {
    protected Bus(double fuel, double fuelConsumption, double tankCapacity) {
        super(fuel, fuelConsumption, tankCapacity);
    }
    @Override
    public void refuel(double liters) {
        if (validateInput(liters)){
            super.fuel += liters;
        }
    }
    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.fuelConsumption = fuelConsumption;
    }
}
