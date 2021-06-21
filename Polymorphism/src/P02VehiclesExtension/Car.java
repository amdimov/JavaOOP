package P02VehiclesExtension;

public class Car extends Vehicles {

    protected Car(double fuel, double fuelConsumption, double tankCapacity) {
        super(fuel, fuelConsumption, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        if(validateInput(liters)){
            super.fuel += liters;
        }
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        fuelConsumption += 0.9;
        super.fuelConsumption = fuelConsumption;
    }
    public void test(){
        System.out.println("test");
    }
}
