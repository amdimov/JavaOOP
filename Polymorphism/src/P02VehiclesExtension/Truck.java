package P02VehiclesExtension;

public class Truck extends Vehicles {

    protected Truck(double fuel, double fuelConsumption, double tankCapacity){
        super(fuel, fuelConsumption, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        if(validateInput(liters)){
            liters = liters * 0.95;
            super.fuel += liters;
        }
    }
    @Override
    public void setFuelConsumption(double fuelConsumption) {
        fuelConsumption += 1.6;
        super.fuelConsumption = fuelConsumption;
    }
}
